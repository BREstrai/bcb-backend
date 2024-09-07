package com.bcb.app.domain.usuario;

import com.brestrai.utils.commons.domain.IDto;
import lombok.Builder;

@Builder
public record UsuarioDto(Long id, String login, String password) implements IDto<Usuario> {
    @Override
    public Usuario toModel() {

        return Usuario.builder()
                .idUsuario(this.id)
                .usuario(this.login)
                .senha(this.password)
                .build();
    }
}
