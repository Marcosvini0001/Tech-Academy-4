package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.model.FormaPagamento;
import com.gympoison.projeto_tech.repository.FormaPagamentoRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FormaPagamentoController {

    private FormaPagamentoRepository repository;
    private List<FormaPagamento> FormaPagamentoRepository;

    public ResponseEntity<List<FormaPagamento>> findAll() {
        List<FormaPagamento> id_forma_pagamento  = this.repository.findAll();
        return ResponseEntity.ok(FormaPagamentoRepository);
    }

    public void setFormaPagamentoRepository(List<FormaPagamento> formaPagamentoRepository) {
        FormaPagamentoRepository = formaPagamentoRepository;
    }
}
