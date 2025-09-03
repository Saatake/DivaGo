package com.upx4.carona.repository;

import com.upx4.carona.domain.entity.Usuaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariaRepository extends JpaRepository<Usuaria, Long> {
    Optional<Usuaria> findByEmail(String email);
}
