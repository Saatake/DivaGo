    package com.upx4.carona.service;

    import com.upx4.carona.domain.entity.Usuaria;
    import com.upx4.carona.dto.UsuariaCreateDTO;
    import com.upx4.carona.dto.UsuariaResponseDTO;
    import com.upx4.carona.repository.UsuariaRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import javax.management.RuntimeOperationsException;
    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class UsuariaService {


        private final UsuariaRepository usuariaRepository;

        @Autowired
        public UsuariaService(UsuariaRepository usuariaRepository) {
            this.usuariaRepository = usuariaRepository;
        }

        //Método para criar uma usuária
        public UsuariaResponseDTO createUsuaria (UsuariaCreateDTO dto) {
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

        //Método para listar todas as usuárias
        public List<UsuariaResponseDTO> findAllUsuarias() {
            List<Usuaria> usuaria = usuariaRepository.findAll();
            List<UsuariaResponseDTO> response = new ArrayList<>();

            for(Usuaria i : usuaria) {
                UsuariaResponseDTO dto = new UsuariaResponseDTO();
                dto.setId(i.getId());
                dto.setNome(i.getNome());
                dto.setEmail(i.getEmail());
                dto.setPapel(i.getPapel());
                response.add(dto);
            }
            return response;
        }

        //Metodo para procurar apenas uma usuaria pelo id
        public UsuariaResponseDTO findById(Long id) {
            Usuaria usuaria = usuariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));

            UsuariaResponseDTO response = new UsuariaResponseDTO();
            response.setId(usuaria.getId());
            response.setNome(usuaria.getNome());
            response.setEmail(usuaria.getEmail());
            response.setPapel(usuaria.getPapel());

            return response;
        }

        //Metodo para atualizar uma usuaria
            public UsuariaResponseDTO updateUsuaria(UsuariaCreateDTO dto, Long id) {
                Usuaria usuaria = usuariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));

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

        //Método para deletar usuárias
        public void deleteUsuaria(Long id) {
            Usuaria usuaria = usuariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));

            usuariaRepository.delete(usuaria);
        }

        //Método para procurar usuária pelo email
        public UsuariaResponseDTO findByEmail(String email) {
            Usuaria usuaria = usuariaRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));

            UsuariaResponseDTO response = new UsuariaResponseDTO();
            response.setId(usuaria.getId());
            response.setNome(usuaria.getNome());
            response.setEmail(usuaria.getEmail());
            response.setPapel(usuaria.getPapel());

            return response;
        }

        //Método para procurar usuária pelo nome
        public UsuariaResponseDTO findByName(String name) {
            Usuaria usuaria = usuariaRepository.findByNome(name).orElseThrow(() -> new RuntimeException("Usuária não encontrada!"));

            UsuariaResponseDTO response = new UsuariaResponseDTO();
            response.setId(usuaria.getId());
            response.setNome(usuaria.getNome());
            response.setEmail(usuaria.getEmail());
            response.setPapel(usuaria.getPapel());

            return response;
        }
    }

