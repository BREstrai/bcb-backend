package com.bcb.app.service.envio;

import com.bcb.app.domain.conta.ContaDto;
import com.bcb.app.domain.conta.TipoAssinatura;
import com.bcb.app.domain.envio.EnvioDto;
import com.bcb.app.repository.envio.EnvioRepository;
import com.bcb.app.service.conta.ContaService;
import com.bcb.app.service.envio.sms.EnvioSmsService;
import com.bcb.app.service.envio.whatsapp.EnvioWhatsappService;
import com.brestrai.utils.commons.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnvioService extends AbstractService {

    private final EnvioRepository envioRepository;

    private final ContaService contaService;

    private final EnvioSmsService envioSmsService;

    private final EnvioWhatsappService envioWhatsappService;

    public void sendMessage(EnvioDto envioDto) {

        try {

            ContaDto contaDto = contaService.findContaByCliente(envioDto.client());

            TipoAssinatura.permiteEnviar(contaDto);

            if (envioDto.isWhatsApp()) {

                envioWhatsappService.enviar(envioDto);

                return;
            }

            envioSmsService.enviar(envioDto);
        } catch (Exception e) {

            String msg = "Não foi possível realizar o envio da mensagem ao destino. " + e.getMessage();

            logInfo(msg);

            throw e;
        }
    }
}
