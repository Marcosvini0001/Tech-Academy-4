package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.UsuarioRequestDTO;
import com.gympoison.projeto_tech.model.Usuario;
import com.gympoison.projeto_tech.repository.UsuarioRepository;
import com.gympoison.projeto_tech.response.UsuarioResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/id_usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        List<Usuario> usuario = repository.findAll();

        if (usuario.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UsuarioResponseDTO> responseDTOList = usuario.stream()
                .map(UsuarioResponseDTO::new)
                .toList();

        return ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Integer id_usuario) {
        Usuario usuario = repository.findById(id_usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        return ResponseEntity.ok(new UsuarioResponseDTO(usuario));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.id_usuario());
        usuario.setNome(dto.nm_usuario());
        usuario.setEmail(dto.email());
        usuario.setCep(dto.cep_usuario());
        usuario.setSenha(dto.senha());
        usuario.setEndereco(dto.end_usuario());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<String> delete(@PathVariable Integer id_usuario) {
        Usuario usuario = repository.findById(id_usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        repository.delete(usuario);
        return ResponseEntity.ok("Usuário removido com sucesso");
    }

    @PutMapping("/{id_usuario}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id_usuario, @Valid @RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id_usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        usuario.setId(dto.id_usuario());
        usuario.setNome(dto.nm_usuario());
        usuario.setEmail(dto.email());
        usuario.setCep(dto.cep_usuario());
        usuario.setSenha(dto.senha());
        usuario.setEndereco(dto.end_usuario());

        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}
