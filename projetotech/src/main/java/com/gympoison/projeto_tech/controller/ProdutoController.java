package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.ProdutoRequestDTO;
import com.gympoison.projeto_tech.repository.ProdutoRepository;
import com.gympoison.projeto_tech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private UsuarioRepository actorRepository;

    @GetMapping
    public ResponseEntity<List<com.exemplo.produto.model.Produto>> findAll() {
        List<com.exemplo.produto.model.Produto> produtos = this.repository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public com.exemplo.produto.model.Produto findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<com.exemplo.produto.model.Produto> save(@RequestBody ProdutoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        com.exemplo.produto.model.Produto produto = new com.exemplo.produto.model.Produto();
        produto.setNome(dto.nome());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        com.exemplo.produto.model.Produto produto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não foi encontrado"));

        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.exemplo.produto.model.Produto> update(@PathVariable Integer id, @RequestBody ProdutoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        com.exemplo.produto.model.Produto produto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        produto.setNome(dto.nome());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @PostMapping("/{id}/preco")
    public ResponseEntity<com.exemplo.produto.model.Produto> addPreco(@PathVariable Integer id,
                                                                      @RequestBody BigDecimal preco) {

        com.exemplo.produto.model.Produto preco = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não foi encontrado"));

        preco.setPreco(preco);

        this.repository.save(preco);
        return ResponseEntity.ok(preco);
    }

    @PostMapping("/{id}/descricao")
    public ResponseEntity<com.exemplo.produto.model.Produto> addDescricao(@PathVariable Integer id,
                                                                          @RequestBody String descricao) {

        com.exemplo.produto.model.Produto produto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto nao foi encontrado"));

        produto.setDescricao(descricao);

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }
}