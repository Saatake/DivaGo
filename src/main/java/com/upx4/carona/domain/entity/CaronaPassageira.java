package com.upx4.carona.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carona_passageira")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaronaPassageira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusCaronaPassageira status;

    @ManyToOne
    @JoinColumn(name = "carona_id")
    private Carona carona;

    @ManyToOne
    @JoinColumn(name = "passageira_id")
    private Usuaria passageira;
}
