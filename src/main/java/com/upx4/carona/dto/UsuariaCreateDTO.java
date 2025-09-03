package com.upx4.carona.dto;

import com.upx4.carona.domain.enums.Papel;
import lombok.Data;

@Data
public class UsuariaCreateDTO {
    private String nome;
    private String email;
    private String senha;
    private Papel papel;
}
