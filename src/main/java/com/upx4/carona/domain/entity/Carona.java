package com.upx4.carona.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carona")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraPartida;
    private BigDecimal valor;
    private String origemTexto;
    private Double origemLatitude;
    private Double origemLongitude;
    private String destinoTexto;
    private Double destinoLatitude;
    private Double destinoLongitude;
    private Double distanciaKm;
    private Integer duracaoMinutos;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Usuaria motorista;

    @OneToMany(mappedBy = "carona", fetch = FetchType.LAZY)
    private List<CaronaPassageira> caronasPassageiras;
}
