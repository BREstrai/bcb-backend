package com.bcb.app.domain.conta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum TipoAssinatura {

    PRE_PAGO(1L),
    POS_PAGO(2L);

    private final Long codigo;

    public static TipoAssinatura to(Long tipoPlano) {

        for (TipoAssinatura plano : TipoAssinatura.values()) {

            if (tipoPlano.equals(plano.getCodigo())) {

                return plano;
            }
        }

        throw new IllegalArgumentException("Plano informado inválido, utilize 1 para Pré Pago ou 2 para Pós Pago.");
    }

    public static void permiteEnviar(ContaDto conta) {

        BigDecimal TAXA = BigDecimal.valueOf(0.25);

        if (conta.plan().equals(PRE_PAGO)) {

            if (conta.available().compareTo(TAXA) <= 0) {

                throw new RuntimeException("Saldo insuficiente para realizar o envio");
            }
        }

        BigDecimal restante = conta.limit().subtract(conta.available());

        if (restante.compareTo(TAXA) <= 0) {

            throw new RuntimeException("Limite para o plano esgotado");
        }
    }
}
