package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.model.FormaPagamento;
import com.gympoison.projeto_tech.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forma_de_pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository repository;

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> findAll() {
        List<FormaPagamento> id_forma_pagamento = this.repository.findAll();
        return ResponseEntity.ok(id_forma_pagamento);
    }
}

