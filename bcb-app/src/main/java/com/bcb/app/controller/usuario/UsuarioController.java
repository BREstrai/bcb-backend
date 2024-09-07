package com.bcb.app.controller.usuario;

import com.bcb.app.domain.usuario.UsuarioDto;
import com.bcb.app.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDto usuarioDto) {

        UsuarioDto login = usuarioService.login(usuarioDto);

        if (nonNull(login)) {

            return ResponseEntity.ok().body(login);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PutMapping
    public void update(@RequestBody UsuarioDto usuarioDto) {

        usuarioService.update(usuarioDto);
    }
}
