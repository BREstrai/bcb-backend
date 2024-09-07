package com.bcb.app.domain.usuario;

import com.bcb.app.domain.cliente.Cliente;
import com.brestrai.utils.commons.domain.IModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements IModel<UsuarioDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String usuario;

    private String senha;

    @ManyToOne
    @JoinColumn(name = "clienteid", nullable = false)
    private Cliente cliente;


    @Override
    public UsuarioDto toDto() {

        return UsuarioDto.builder()
                .id(this.idUsuario)
                .login(this.usuario)
                .build();
    }
}
