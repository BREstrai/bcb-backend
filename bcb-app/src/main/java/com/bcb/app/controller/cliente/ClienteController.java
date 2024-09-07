package com.bcb.app.controller.cliente;

import com.bcb.app.domain.cliente.ClienteDto;
import com.bcb.app.service.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> findAllClientes() {

        return clienteService.findAllClientes();
    }

    @PostMapping
    public void create(@RequestBody ClienteDto clienteDto) {

        clienteService.createOrUpdate(clienteDto);
    }
}
