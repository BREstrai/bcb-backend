package com.bcb.app.service.conta.recarga;

import com.bcb.app.domain.cliente.Cliente;
import com.bcb.app.domain.conta.Conta;
import com.bcb.app.domain.conta.recarga.Recarga;
import com.bcb.app.domain.conta.recarga.RecargaDto;
import com.bcb.app.repository.conta.recarga.RecargaRepository;
import com.bcb.app.service.cliente.ClienteService;
import com.bcb.app.service.conta.ContaService;
import com.brestrai.utils.commons.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecargaService extends AbstractService {

    private final RecargaRepository recargaRepository;

    private final ContaService contaService;

    private final ClienteService clienteService;

    public void buyCredit(RecargaDto recargaDto) {

        Recarga recarga = recargaDto.toModel();

        validInformations(recarga);

        recargaRepository.save(recarga);

        atualizarSaldo(recarga);
    }

    private void atualizarSaldo(Recarga recarga) {

        Conta conta = recarga.getConta();
        conta.setSaldo(conta.getSaldo().add(recarga.getValor()));

        contaService.update(conta);
    }

    private void validInformations(Recarga recarga) {

        try {

            Conta conta = contaService.findContaById(recarga.getConta().getIdConta());
            recarga.setConta(conta);

            Cliente cliente = clienteService.findClienteById(recarga.getRepresentante().getIdCliente());
            recarga.setRepresentante(cliente);
        } catch (Exception e) {

            String msg = "Tentativa de realizar uma recarga indevida. " + e.getMessage();

            logInfo(msg);

            throw e;
        }
    }
}
