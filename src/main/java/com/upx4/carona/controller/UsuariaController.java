package com.upx4.carona.controller;

import com.upx4.carona.domain.entity.Usuaria;
import com.upx4.carona.dto.UsuariaCreateDTO;
import com.upx4.carona.dto.UsuariaResponseDTO;
import com.upx4.carona.repository.UsuariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuaria")
public class UsuariaController {

    @Autowired
    UsuariaRepository usuariaRepository;

    //Cadastrar usuária
    @PostMapping
    public UsuariaResponseDTO saveUsuarias(@RequestBody UsuariaCreateDTO dto) {
        Usuaria usuaria = new Usuaria();
        usuaria.setNome(dto.getNome());
        usuaria.setEmail(dto.getEmail());
        usuaria.setSenha(dto.getSenha());
        usuaria.setPapel(dto.getPapel());

        Usuaria usuariaSalva = usuariaRepository.save(usuaria);

        UsuariaResponseDTO response = new UsuariaResponseDTO();
        response.setId(usuariaSalva.getId());
        response.setNome(usuariaSalva.getNome());
        response.setEmail(usuariaSalva.getEmail());
        response.setPapel(usuariaSalva.getPapel());

        return response;
    }

    //Listar todas as usuárias no banco
    @GetMapping
    public List<UsuariaResponseDTO> findAllUsuarias() {
        List<Usuaria> usuarias = usuariaRepository.findAll();
        List<UsuariaResponseDTO> response = new ArrayList<>();

        for (Usuaria i : usuarias) {
            UsuariaResponseDTO dto = new UsuariaResponseDTO();
            dto.setId(i.getId());
            dto.setNome(i.getNome());
            dto.setEmail(i.getEmail());
            dto.setPapel(i.getPapel());
            response.add(dto);

        }
        return response;
    }

    //Atualizar os dados de uma usuária existente
    @PutMapping("/{id}")
    public UsuariaResponseDTO updateUsuaria(@PathVariable Long id, @RequestBody UsuariaCreateDTO dto) {
        Usuaria usuaria = usuariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));
        usuaria.setNome(dto.getNome());
        usuaria.setEmail(dto.getEmail());
        usuaria.setSenha(dto.getSenha());
        usuaria.setPapel(dto.getPapel());

        Usuaria usuariaUpdate = usuariaRepository.save(usuaria);

        UsuariaResponseDTO response = new UsuariaResponseDTO();
        response.setId(usuariaUpdate.getId());
        response.setNome(usuariaUpdate.getNome());
        response.setEmail(usuariaUpdate.getEmail());
        response.setPapel(usuariaUpdate.getPapel());

        return response;
    }

    //Deletar usuária pelo id no banco
    @DeleteMapping("/{id}")
    public void deleteUsuaria(@PathVariable Long id) {
        Usuaria usuaria = usuariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));

        usuariaRepository.delete(usuaria);
    }

    //Pegar os dados de uma usuária pelo id no banco
    @GetMapping("/{id}")
    public UsuariaResponseDTO findByIdUsuaria(@PathVariable Long id) {
        Usuaria usuaria = usuariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));
        UsuariaResponseDTO response = new UsuariaResponseDTO();

        response.setId(usuaria.getId());
        response.setNome(usuaria.getNome());
        response.setEmail(usuaria.getEmail());
        response.setPapel(usuaria.getPapel());

        return response;
    }
}