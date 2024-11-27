package com.gympoison.projeto_tech.controller;

import com.exemplo.produto.model.Produto;
import com.gympoison.projeto_tech.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PagamentoController {

    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> pagamento = this.repository.findAll();
        return ResponseEntity.ok(pagamento);
    }
}