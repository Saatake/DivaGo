package com.upx4.carona.repository;

import com.upx4.carona.domain.entity.CaronaPassageira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaronaPassageiraRepository extends JpaRepository<CaronaPassageira, Long> {
    //Listar todas as passageiras de uma carona
    List<CaronaPassageira> findByCaronaId(Long caronaId);

    //Listar todas as caronas de uma passageira
    List<CaronaPassageira> findByPassageiraId(Long passageiraId);
}
