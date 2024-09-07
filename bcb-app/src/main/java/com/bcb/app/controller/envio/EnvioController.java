package com.bcb.app.controller.envio;

import com.bcb.app.domain.envio.EnvioDto;
import com.bcb.app.service.envio.EnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/envio")
public class EnvioController {

    private final EnvioService envioService;

    @PostMapping
    public void sendMessage(@RequestBody EnvioDto envioDto) {

        envioService.sendMessage(envioDto);
    }

}
