package com.bcb.app.service.usuario;

import com.bcb.app.domain.cliente.Cliente;
import com.bcb.app.domain.usuario.Usuario;
import com.bcb.app.domain.usuario.UsuarioDto;
import com.bcb.app.repository.usuario.UsuarioRepository;
import com.brestrai.utils.commons.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService extends AbstractService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDto login(UsuarioDto usuarioDto) {

        Usuario usuarioByUsuarioAndSenha = usuarioRepository.findUsuarioByUsuarioAndSenha(usuarioDto.login(),
                usuarioDto.password());

        return usuarioByUsuarioAndSenha.toDto();
    }

    public void create(Cliente cliente) {

        Usuario usuario = Usuario.builder()
                .usuario(cliente.getEmail())
                .senha(cliente.getCnpj().concat("#AlterarPrimeiroAcesso#"))
                .cliente(cliente)
                .build();

        usuarioRepository.save(usuario);
    }

    public void update(UsuarioDto usuarioDto) {

        Optional<Usuario> usuario = usuarioRepository.findById(usuarioDto.id());

        usuario.ifPresent(user -> {

            user.setSenha(usuarioDto.password());

            usuarioRepository.save(user);
        });

        throw new IllegalArgumentException("Não foi possível tratar os dados do usuário enviado.");
    }
}
