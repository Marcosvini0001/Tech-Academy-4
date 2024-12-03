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
@RequestMapping("/id_item_pedido")
public class IpedidoController {

    @Autowired
    private IpedidoRepository ipedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemRepository itemRepository;

  
    @GetMapping
    public ResponseEntity<List<Ipedido>> findAll() {
        List<Ipedido> itemPedido = ipedidoRepository.findAll();
        return ResponseEntity.ok(itemPedido);
    }


    @GetMapping("/{id_item_pedido}")
    public ResponseEntity<Ipedido> findById(@PathVariable Integer id_item_pedido, @Valid @RequestBody IpedidoRequestDTO dto) {
        Ipedido ipedido = ipedidoRepository.findById(id_item_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do pedido não encontrado"));
        return ResponseEntity.ok(ipedido);
    }


    @PostMapping
    public ResponseEntity<Ipedido> create(@PathVariable Integer id_item_pedido, @Valid @RequestBody IpedidoRequestDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Item item = itemRepository.findById(dto.id_item_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        Ipedido ipedido = new Ipedido();
        ipedido.setPedido(pedido);
        ipedido.setItem(item);
        ipedido.setQuantidade(dto.quantidade());
        ipedido.setPreco_unitario(dto.preco_unitario());
        ipedido.setTotal_item(dto.total_item());
        ipedido.setId_item_pedido(dto.id_item_pedido());

        ipedidoRepository.save(ipedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(ipedido);
    }

    @PutMapping("/{id_item_pedido}")
    public ResponseEntity<Ipedido> update(@PathVariable Integer id_item_pedido, @Valid @RequestBody IpedidoRequestDTO dto) {
        Ipedido ipedido = ipedidoRepository.findById(id_item_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do pedido não encontrado"));

        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Item item = itemRepository.findById(dto.id_item_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        ipedido.setPedido(pedido);
        ipedido.setItem(item);
        ipedido.setQuantidade(dto.quantidade());
        ipedido.setPreco_unitario(dto.preco_unitario());
        ipedido.setTotal_item(dto.total_item());
        ipedido.setId_item_pedido(dto.id_item_pedido());
        ipedidoRepository.save(ipedido);
        return ResponseEntity.ok(ipedido);
    }

    @DeleteMapping("/{id_item_pedido}")
    public ResponseEntity<Ipedido> delete(@PathVariable Integer id_item_pedido, @Valid @RequestBody IpedidoRequestDTO dto) {
        Ipedido ipedido = ipedidoRepository.findById(id_item_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do pedido não encontrado"));

        ipedidoRepository.delete(ipedido);
        return ResponseEntity.noContent().build();
    }

}
