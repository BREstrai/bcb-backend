package com.bcb.app.domain.conta.recarga;

import com.bcb.app.domain.cliente.ClienteDto;
import com.bcb.app.domain.conta.ContaDto;
import com.brestrai.utils.commons.domain.IDto;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record RecargaDto(Long id, ContaDto acount, ClienteDto representative,
                         BigDecimal value, LocalDateTime dhRegister) implements IDto<Recarga> {
    @Override
    public Recarga toModel() {

        return Recarga.builder()
                .idRecarga(this.id)
                .conta(this.acount.toModel())
                .representante(this.representative().toModel())
                .valor(this.value)
                .dhRegistro(this.dhRegister)
                .build();
    }
}
