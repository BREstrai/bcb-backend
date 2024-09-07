package com.bcb.app.domain.cliente;

import com.brestrai.utils.commons.domain.IModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements IModel<ClienteDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;

    private String nomeEmpresa;

    private String email;

    private String cnpj;

    private String cpf;

    private String telefone;

    private LocalDateTime dhCriacao;

    @Override
    public ClienteDto toDto() {

        return ClienteDto.builder()
                .id(this.idCliente)
                .name(this.nome)
                .nameCompany(this.nomeEmpresa)
                .cnpj(this.cnpj)
                .cpf(this.cpf)
                .email(this.email)
                .phone(this.telefone)
                .dhCreate(this.dhCriacao)
                .build();
    }
}
