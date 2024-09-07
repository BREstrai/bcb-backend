package com.bcb.app.controller.conta.recarga;

import com.bcb.app.domain.conta.recarga.RecargaDto;
import com.bcb.app.service.conta.recarga.RecargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recarga")
public class RecargaController {

    private final RecargaService recargaService;

    @PostMapping
    public void buyCredit(@RequestBody RecargaDto recargaDto) {

        recargaService.buyCredit(recargaDto);
    }
}
