package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.IpedidoRequestDTO;
import com.gympoison.projeto_tech.model.Ipedido;
import com.gympoison.projeto_tech.model.Item;
import com.gympoison.projeto_tech.model.Pedido;
import com.gympoison.projeto_tech.repository.IpedidoRepository;
import com.gympoison.projeto_tech.repository.ItemRepository;
import com.gympoison.projeto_tech.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/item_pedidos")
public class IpedidoController {

    @Autowired
    private IpedidoRepository ipedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public ResponseEntity<List<Ipedido>> findAll() {
        List<Ipedido> ipedidos = ipedidoRepository.findAll();
        return ResponseEntity.ok(ipedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ipedido> findById(@PathVariable Integer id_item_pedido) {
        Ipedido ipedido = ipedidoRepository.findById(id_item_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do pedido não encontrado"));
        return ResponseEntity.ok(ipedido);
    }

    @PostMapping
    public ResponseEntity<Ipedido> create(@Valid @RequestBody IpedidoRequestDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Item item = itemRepository.findById(dto.id_produto())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        Ipedido ipedido = new Ipedido();
        ipedido.setId_pedido(dto.id_pedido());
        ipedido.setId_produto(dto.id_produto());
        ipedido.setQuantidade(dto.quantidade());
        ipedido.setPreco_unitario(dto.preco_unitario());
        ipedido.setTotal_item(dto.total_item());

        ipedidoRepository.save(ipedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(ipedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ipedido> update(@PathVariable Integer id, @Valid @RequestBody IpedidoRequestDTO dto) {
        Ipedido ipedido = ipedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do pedido não encontrado"));

        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Item item = itemRepository.findById(dto.id_produto())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        ipedido.setId_pedido(dto.id_pedido());
        ipedido.setId_produto(dto.id_produto());
        ipedido.setQuantidade(dto.quantidade());
        ipedido.setPreco_unitario(dto.preco_unitario());
        ipedido.setTotal_item(dto.total_item());

        ipedidoRepository.save(ipedido);
        return ResponseEntity.ok(ipedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Ipedido ipedido = ipedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do pedido não encontrado"));

        ipedidoRepository.delete(ipedido);
        return ResponseEntity.noContent().build();
    }
}
