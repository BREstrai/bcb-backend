package com.bcb.app.service.envio.whatsapp;

import com.bcb.app.domain.envio.EnvioDto;
import com.bcb.app.repository.envio.EnvioRepository;
import com.bcb.app.service.conta.ContaService;
import com.bcb.app.service.envio.AbstractEnvio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class EnvioWhatsappService extends AbstractEnvio {
    public EnvioWhatsappService(EnvioRepository envioRepository, ContaService contaService) {

        super(envioRepository, contaService);
    }

    @Override
    public void enviar(EnvioDto envioDto) {

        Message message = Message.creator(
                new PhoneNumber("whatsapp:".concat(envioDto.destination())),
                new PhoneNumber("whatsapp:+14158497050"),
                envioDto.message()
        ).create();

        logInfo(message.getSid());

        subtractBalance(envioDto);
    }
}