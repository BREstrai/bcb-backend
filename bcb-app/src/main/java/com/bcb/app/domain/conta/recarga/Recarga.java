package com.bcb.app.domain.conta.recarga;

import com.bcb.app.domain.cliente.Cliente;
import com.bcb.app.domain.conta.Conta;
import com.brestrai.utils.commons.domain.IModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recarga")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recarga implements IModel<RecargaDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecarga;

    @ManyToOne
    @JoinColumn(name = "contaid", nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "clienteid", nullable = false)
    private Cliente representante;

    private BigDecimal valor;

    private LocalDateTime dhRegistro;

    @Override
    public RecargaDto toDto() {

        return RecargaDto.builder()
                .acount(this.conta.toDto())
                .representative(this.representante.toDto())
                .value(this.valor)
                .dhRegister(this.dhRegistro)
                .build();
    }
}
