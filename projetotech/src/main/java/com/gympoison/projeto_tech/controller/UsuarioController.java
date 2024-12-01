package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.UsuarioRequestDTO;
import com.gympoison.projeto_tech.model.Usuario;
import com.gympoison.projeto_tech.repository.UsuarioRepository;
import com.gympoison.projeto_tech.response.UsuarioResponseDTO;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

        @Autowired
        private UsuarioRepository repository;

        private UsuarioResponseDTO responseDTO;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        List<Usuario> usuario = repository.findAll(); // esta dando erro nessa linha
        List<UsuarioResponseDTO> responseDTO = usuario.stream()
                .map(UsuarioResponseDTO::new)
                .toList();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Integer id) {
        Usuario usuario = repository.findById(Id_usuario).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        return ResponseEntity.ok(new UsuarioResponseDTO(usuario));}


    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioRequestDTO dto){

        Usuario usuario = new Usuario();
        usuario.setId(dto.id());
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setCep(dto.cep());
        usuario.setEndereco(dto.endereco());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Usuario usuario = repository.findById(Id_usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        repository.delete(usuario);
        return ResponseEntity.ok("Usuário removido com sucesso");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id,@Valid @RequestBody UsuarioRequestDTO dto){
        Usuario usuario = repository.findById(Id_usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        usuario.setId(dto.id());
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setCep(dto.cep());
        usuario.setEndereco(dto.endereco());

        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

}

