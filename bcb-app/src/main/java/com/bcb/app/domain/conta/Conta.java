package com.bcb.app.domain.conta;

import com.bcb.app.domain.cliente.Cliente;
import com.brestrai.utils.commons.domain.IModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static com.bcb.app.domain.conta.TipoAssinatura.PRE_PAGO;

@Entity
@Table(name = "conta")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conta implements IModel<ContaDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @ManyToOne
    @JoinColumn(name = "clienteid", nullable = false)
    private Cliente cliente;

    private Long tipoPlano;

    private BigDecimal limite;

    private BigDecimal saldo;

    @Override
    public ContaDto toDto() {
        return ContaDto.builder()
                .id(this.idConta)
                .client(this.cliente.toDto())
                .plan(TipoAssinatura.to(this.tipoPlano))
                .limit(this.limite)
                .available(this.saldo)
                .build();
    }

    public void atualizarSaldo() {

        BigDecimal TAXA = BigDecimal.valueOf(0.25);

        if (TipoAssinatura.to(this.tipoPlano).equals(PRE_PAGO)) {

            BigDecimal restante = this.getSaldo().subtract(TAXA);

            setSaldo(restante);

            return;
        }

        setSaldo(this.getSaldo().add(TAXA));
    }
}
