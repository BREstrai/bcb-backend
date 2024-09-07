package com.bcb.app.domain.envio;

import com.bcb.app.domain.cliente.Cliente;
import com.brestrai.utils.commons.domain.IModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "envio")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Envio implements IModel<EnvioDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;

    @ManyToOne
    @JoinColumn(name = "clienteid", nullable = false)
    private Cliente idCliente;

    private String destino;

    private String mensagem;

    private LocalDateTime dhEnvio;

    private boolean isWhatsApp;

    @Override
    public EnvioDto toDto() {

        return EnvioDto.builder()
                .id(this.idEnvio)
                .client(this.idCliente.toDto())
                .destination(this.destino)
                .message(this.mensagem)
                .isWhatsApp(this.isWhatsApp)
                .dhSended(this.dhEnvio)
                .build();
    }
}
