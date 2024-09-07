package com.bcb.app.domain.envio;

import com.bcb.app.domain.cliente.ClienteDto;
import com.brestrai.utils.commons.domain.IDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EnvioDto(Long id, ClienteDto client, String destination, String message,
                       LocalDateTime dhSended, boolean isWhatsApp) implements IDto<Envio> {
    @Override
    public Envio toModel() {

        return Envio.builder()
                .idEnvio(this.id)
                .idCliente(this.client.toModel())
                .destino(this.destination)
                .mensagem(this.message)
                .isWhatsApp(this.isWhatsApp)
                .dhEnvio(this.dhSended)
                .build();
    }
}
