package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.model.Usuario;
import com.gympoison.projeto_tech.repository.ProdutoRepository;
import com.gympoison.projeto_tech.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UsuarioController {

        private UsuarioRepository repository;

        @GetMapping
        public ResponseEntity<List<com.gympoison.projeto_tech.controller.UsuarioController>> findAll(){
            List<Usuario> usuario = this.repository.findAll();
            return ResponseEntity.ok(usuario);
        }
}
