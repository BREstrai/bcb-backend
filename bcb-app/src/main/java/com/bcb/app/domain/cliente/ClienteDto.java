package com.bcb.app.domain.cliente;

import com.brestrai.utils.commons.domain.IDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ClienteDto(Long id, String name, String nameCompany, String email, String cnpj, String cpf,
                         String phone, LocalDateTime dhCreate) implements IDto<Cliente> {
    @Override
    public Cliente toModel() {

        return Cliente.builder()
                .idCliente(this.id)
                .nome(this.name)
                .nomeEmpresa(this.nameCompany)
                .cnpj(this.cnpj)
                .cpf(this.cpf)
                .email(this.email)
                .telefone(this.phone)
                .dhCriacao(this.dhCreate)
                .build();
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", dhCreate=" + dhCreate +
                '}';
    }
}
