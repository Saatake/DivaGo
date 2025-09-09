package com.upx4.carona.repository;

import com.upx4.carona.domain.entity.Carona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaronasRepository extends JpaRepository<Carona, Long> {
    List<Carona> findByMotoristaId(Long motoristaId);
}
