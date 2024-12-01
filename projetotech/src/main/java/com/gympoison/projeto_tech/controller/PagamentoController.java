package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.model.Pagamento;
import com.gympoison.projeto_tech.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PagamentoController {

    private ItemRepository repository;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll(){
        List<Pagamento> pagamento = this.repository.findAll();
        return ResponseEntity.ok(pagamento);
    }
}