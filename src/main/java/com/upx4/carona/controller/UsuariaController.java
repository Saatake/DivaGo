package com.upx4.carona.controller;

import com.upx4.carona.domain.entity.Usuaria;
import com.upx4.carona.dto.UsuariaCreateDTO;
import com.upx4.carona.dto.UsuariaResponseDTO;
import com.upx4.carona.repository.UsuariaRepository;
import com.upx4.carona.service.UsuariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarias")
public class UsuariaController {

    private final UsuariaService usuariaService;

    @Autowired
    public UsuariaController(UsuariaService usuariaService) {
        this.usuariaService = usuariaService;
    }

    @PostMapping
    public UsuariaResponseDTO criarUsuaria(@RequestBody UsuariaCreateDTO dto) {
        return usuariaService.createUsuaria(dto);
    }

    @GetMapping
    public List<UsuariaResponseDTO> listarUsuaria() {
        return usuariaService.findAllUsuarias();
    }

    @PutMapping("/{id}")
    public UsuariaResponseDTO atualizarUsuaria(@RequestBody UsuariaCreateDTO dto, @PathVariable Long id) {
        return usuariaService.updateUsuaria(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuaria(@PathVariable Long id) {
        usuariaService.deleteUsuaria(id);
    }

    @GetMapping("/id/{id}")
    public UsuariaResponseDTO findByIdUsuaria(@PathVariable Long id) {
        return usuariaService.findById(id);
    }

    @GetMapping("/email/by/{email}")
    public UsuariaResponseDTO findByEmailUsuaria(@PathVariable String email) {
        return usuariaService.findByEmail(email);
    }

    @GetMapping("/nome/by/{nome}")
    public UsuariaResponseDTO findByNomeUsuaria(@PathVariable String nome) {
        return usuariaService.findByName(nome);
    }
}