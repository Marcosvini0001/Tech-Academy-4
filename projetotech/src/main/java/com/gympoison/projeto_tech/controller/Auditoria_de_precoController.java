package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.model.Auditoria_de_preco;
import com.gympoison.projeto_tech.repository.Auditoria_de_precoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auditoria_de_preco")
public class Auditoria_de_precoController {

    @Autowired
    private Auditoria_de_precoRepository auditoriaDePrecoRepository;

    @GetMapping
    public ResponseEntity<List<Auditoria_de_preco>> findAll() {
        List<Auditoria_de_preco> auditoriaDePrecos = this.auditoriaDePrecoRepository.findAll();
        return ResponseEntity.ok(auditoriaDePrecos);
    }
}
