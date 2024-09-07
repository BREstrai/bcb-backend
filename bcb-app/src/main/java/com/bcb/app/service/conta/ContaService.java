package com.bcb.app.service.conta;

import com.bcb.app.domain.cliente.ClienteDto;
import com.bcb.app.domain.conta.Conta;
import com.bcb.app.domain.conta.ContaDto;
import com.bcb.app.repository.conta.ContaRepositoy;
import com.bcb.app.service.cliente.ClienteService;
import com.brestrai.utils.commons.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ContaService extends AbstractService {

    private final ContaRepositoy contaRepositoy;

    private final ClienteService clienteService;

    public ContaDto findContaByCliente(ClienteDto clienteDto) {

        Conta conta = contaRepositoy.findByCliente(clienteDto.toModel());

        if (isNull(conta)) {

            String msg = "Não foi possível localizar a conta através do usuário informado";

            logInfo(msg.concat(clienteDto.toString()));

            throw new IllegalArgumentException(msg);
        }

        return conta.toDto();
    }

    public void create(ContaDto contaDto) {

        try {

            validClient(contaDto);

            Conta contaByCliente = contaRepositoy.findByCliente(contaDto.client().toModel());

            if (nonNull(contaByCliente)) {

                contaByCliente.setTipoPlano(contaDto.plan().getCodigo());
                contaByCliente.setLimite(contaDto.limit());

                contaRepositoy.save(contaByCliente);

                return;
            }

            Conta conta = contaDto.toModel();
            conta.setSaldo(BigDecimal.ZERO);

            contaRepositoy.save(conta);
        } catch (Exception e) {

            logInfo("Tentativa de cadastrar um plano para um cliente inválido");

            throw e;
        }

    }

    private void validClient(ContaDto contaDto) {

        clienteService.findClienteById(contaDto.client().id());
    }

    public Conta findContaById(Long idConta) {

        return contaRepositoy.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possível localizar a conta " +
                        "para o código informado"));
    }

    public void update(Conta conta) {

        contaRepositoy.save(conta);
    }
}
