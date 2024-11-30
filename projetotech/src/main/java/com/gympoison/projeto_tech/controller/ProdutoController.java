package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.ProdutoRequestDTO;
import com.gympoison.projeto_tech.repository.ProdutoRepository;
import com.gympoison.projeto_tech.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.gympoison.projeto_tech.model.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produto = this.repository.findAll();
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
       Produto produto = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@Valid @RequestBody ProdutoRequestDTO dto) {

        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());
        produto.setCategoria(dto.categoria());
        preco.setStatus(dto.status());

        this.repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        com.exemplo.produto.model.Produto produto = this.repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));

        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @Valid @RequestBody ProdutoRequestDTO dto) {

        Produto produto = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());
        produto.setStatus(dto.status());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }
}