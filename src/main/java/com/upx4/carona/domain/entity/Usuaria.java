package com.upx4.carona.domain.entity;

import com.upx4.carona.domain.enums.Papel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuaria")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    private Papel papel;

    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private List<Carona> caronasComoMotorista;

    @OneToMany(mappedBy = "passageira", fetch = FetchType.LAZY)
    private List<CaronaPassageira> caronasComoPassageira;

}
