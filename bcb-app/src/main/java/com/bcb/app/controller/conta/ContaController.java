package com.bcb.app.controller.conta;

import com.bcb.app.domain.cliente.ClienteDto;
import com.bcb.app.domain.conta.ContaDto;
import com.bcb.app.service.conta.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    @PostMapping
    public void store(@RequestBody ContaDto contaDto) {

        contaService.create(contaDto);
    }

    @GetMapping
    public ContaDto view(@RequestBody ClienteDto clienteDto) {

        return contaService.findContaByCliente(clienteDto);
    }
}
