package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.ItemRequestDTO;
import com.gympoison.projeto_tech.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.gympoison.projeto_tech.model.Item;

import java.util.List;

@RestController
@RequestMapping("/id_item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        List<Item> item = this.repository.findAll();
        return ResponseEntity.ok(item);
    }

    @GetMapping("/id_item_pedido")
    public ResponseEntity<Item> findById(@PathVariable Integer id_item) {
       Item item = this.repository.findById(id_item)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> save(@Valid @RequestBody ItemRequestDTO dto) {

        Item item= new Item();
        item.setNome_item(dto.nome_item());
        item.setPreco_atual(dto.preco_atual());
        item.setDescricao(dto.descricao());
        item.setCategoria(dto.categoria());
        item.setStatus(dto.status());

        this.repository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }


    @DeleteMapping("/id_item_pedido")
    public ResponseEntity<Void> delete(@PathVariable Integer id_item) {
        Item item = this.repository.findById(id_item)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));

        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id_item_pedido")
    public ResponseEntity<Item> update(@PathVariable Integer id_item, @Valid @RequestBody ItemRequestDTO dto) {

        Item item = this.repository.findById(id_item)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));

        item.setNome_item(dto.nome_item());
        item.setPreco_atual(dto.preco_atual());
        item.setDescricao(dto.descricao());
        item.setStatus(dto.status());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }
}