package com.bcb.app.repository.conta;

import com.bcb.app.domain.cliente.Cliente;
import com.bcb.app.domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepositoy extends JpaRepository<Conta, Long> {

    Conta findByCliente(Cliente cliente);
}
