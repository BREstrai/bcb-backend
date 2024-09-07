package com.bcb.app.domain.conta;

import com.bcb.app.domain.cliente.ClienteDto;
import com.brestrai.utils.commons.domain.IDto;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ContaDto(Long id, ClienteDto client, TipoAssinatura plan, BigDecimal limit,
                       BigDecimal available) implements IDto<Conta> {
    @Override
    public Conta toModel() {

        return Conta.builder()
                .idConta(this.id)
                .cliente(this.client.toModel())
                .tipoPlano(this.plan.getCodigo())
                .limite(this.limit)
                .saldo(this.available)
                .build();
    }
}
