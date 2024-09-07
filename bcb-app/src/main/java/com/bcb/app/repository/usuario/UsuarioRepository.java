package com.bcb.app.repository.usuario;

import com.bcb.app.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByUsuarioAndSenha(String login, String senha);
}
