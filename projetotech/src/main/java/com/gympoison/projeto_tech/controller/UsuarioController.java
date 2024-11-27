package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UsuarioController {

        private UsuarioRepository repository;

        @GetMapping
        public ResponseEntity<List<UsuarioRepository>> findAll(){
            List<UsuarioRepository> usuario = this.repository.findAll();
            return ResponseEntity.ok(usuario);
        }
}
