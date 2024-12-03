package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.ItemRequestDTO;
import com.gympoison.projeto_tech.model.Usuario;
import com.gympoison.projeto_tech.repository.ItemRepository;
import com.gympoison.projeto_tech.response.ItemResponseDTO;
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
    public ResponseEntity<List<ItemResponseDTO>> findAll() {
        List<Item> item = repository.findAll();

        if (item.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<ItemResponseDTO> responseDTOList = item.stream()
                .map(ItemResponseDTO::new)
                .toList();

        return ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/{id_item}")
    public ResponseEntity<ItemResponseDTO> findById(@PathVariable Integer id_item) {
       Item item = this.repository.findById(id_item)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));
        return ResponseEntity.ok(new ItemResponseDTO(item));
    }

    @PostMapping
    public ResponseEntity<Item> save(@org.jetbrains.annotations.NotNull @Valid @RequestBody ItemRequestDTO dto) {
        Item item= new Item();
        item.setId_item(dto.id_item());
        item.setNome_item(dto.nome_item());
        item.setPreco_atual(dto.preco_atual());
        item.setEstoque(dto.estoque());
        item.setDescricao(dto.descricao());
        item.setCategoria(dto.categoria());
        item.setData_cadastro(dto.data_cadastro());
        item.setStatus(dto.status());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }


    @DeleteMapping("/{id_item}")
    public ResponseEntity<Void> delete(@PathVariable Integer id_item) {
        Item item = this.repository.findById(id_item)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));

        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id_item}")
    public ResponseEntity<Item> update(@PathVariable Integer id_item, @Valid @RequestBody ItemRequestDTO dto) {

        Item item = this.repository.findById(id_item)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não foi encontrado"));

        item.setId_item(dto.id_item());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }
}