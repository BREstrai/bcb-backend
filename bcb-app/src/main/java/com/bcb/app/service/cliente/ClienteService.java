package com.bcb.app.service.cliente;

import com.bcb.app.domain.cliente.Cliente;
import com.bcb.app.domain.cliente.ClienteDto;
import com.bcb.app.repository.cliente.ClienteRepository;
import com.bcb.app.service.usuario.UsuarioService;
import com.brestrai.utils.commons.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ClienteService extends AbstractService {

    private final ClienteRepository clienteRepository;

    private final UsuarioService usuarioService;

    public void createOrUpdate(ClienteDto clienteDto) {

        Cliente clienteExistente = clienteRepository.findClienteByEmail(clienteDto.email());

        if (nonNull(clienteExistente)) {

            clienteExistente.setNome(clienteDto.name());
            clienteExistente.setNomeEmpresa(clienteDto.nameCompany());
            clienteExistente.setTelefone(clienteDto.phone());
            clienteExistente.setDhCriacao(LocalDateTime.now());

            clienteRepository.save(clienteExistente);

            return;
        }

        Cliente cliente = clienteRepository.save(clienteDto.toModel());

        usuarioService.create(cliente);
    }

    public List<ClienteDto> findAllClientes() {

        List<Cliente> allClientes = clienteRepository.findAll();

        return allClientes.stream().map(Cliente::toDto).collect(Collectors.toList());
    }

    public Cliente findClienteById(Long idCliente) {

        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possível localizar o cliente informado"));
    }
}
