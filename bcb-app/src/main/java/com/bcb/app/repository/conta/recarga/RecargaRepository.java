package com.bcb.app.repository.conta.recarga;

import com.bcb.app.domain.conta.recarga.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargaRepository extends JpaRepository<Recarga, Long> {
}
