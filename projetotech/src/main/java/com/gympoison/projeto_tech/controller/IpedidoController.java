package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.IpedidoRequestDTO;
import com.gympoison.projeto_tech.model.Ipedido;
import com.gympoison.projeto_tech.model.Item;
import com.gympoison.projeto_tech.model.Pedido;
import com.gympoison.projeto_tech.repository.ItemRepository;
import com.gympoison.projeto_tech.repository.PagamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class IpedidoController {

    @Autowired
    private PagamentoRepository repository;

    @GetMapping("/item_pedidos")
    public ResponseEntity<List<Ipedido>> findAll() {
        List<ItemRepository> pedido = repository.findAll();
        return ResponseEntity.ok(Ipedido);
    }
}

    @GetMapping("/{id}")
    public ResponseEntity <Ipedido> findById(@PathVariable Integer id_item_pedido){
        Ipedido itempedido = repository.findById(id_item_pedido).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

        return ResponseEntity.ok(itempedido);
    }



    @PostMapping
    public ResponseEntity <Ipedido> create(@Valid @RequestBody IpedidoRequestDTO dto) {
        Pedido pedido = IpedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Item item = ItemRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));


        Ipedido itempedido = new Ipedido();
        itempedido.setId_pedido(dto.id_pedido());
        itempedido.setProdutoId(produto);

        itempedido.setPreco(dto.preco());
        itempedido.setQuantidade(dto.quantidade());


        repository.save(itempedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(Ipedido);

    }

    @PutMapping("/{id}")
    public ResponseEntity <Ipedido> update(@PathVariable Integer id, @Valid @RequestBody IpedidoRequestDTO dto) {
        Ipedido itempedido = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

        Pedido pedido = pedidoRepository.findById(dto.pedidoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        itempedido.setPedidoId(pedido);
        itempedido.setProdutoId(produto);
        itempedido.setPreco(dto.preco());
        itempedido.setQuantidade(dto.quantidade());

        repository.save(itempedido);
        return ResponseEntity.ok(Ipedido);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Ipedido> delete(@PathVariable Integer id){
        Ipedido itempedido = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

        repository.delete(itempedido);
        return ResponseEntity.noContent().build();
    }
