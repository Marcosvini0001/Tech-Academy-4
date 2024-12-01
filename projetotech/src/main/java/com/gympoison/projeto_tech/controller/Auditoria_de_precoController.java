package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.model.FormaPagamento;
import com.gympoison.projeto_tech.repository.FormaPagamentoRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Auditoria_de_precoController {

    private com.gympoison.projeto_tech.repository.FormaPagamentoRepository repository;
    private List<com.exemplo.produto.model.Produto> Auditoria_de_precoRepository;

    public ResponseEntity<List<com.exemplo.produto.model.Produto>> findAll() {
        List<FormaPagamento> Auditoria_de_preco  = this.repository.findAll();
        return ResponseEntity.ok(Auditoria_de_precoRepository);
    }
}