package com.upx4.carona.dto;

import com.upx4.carona.domain.enums.Papel;
import lombok.Data;

@Data
public class UsuariaResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Papel papel;
}
