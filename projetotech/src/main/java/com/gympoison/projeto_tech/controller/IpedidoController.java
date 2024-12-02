package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.IpedidoRequestDTO;
import com.gympoison.projeto_tech.model.Ipedido;
import com.gympoison.projeto_tech.model.Item;
import com.gympoison.projeto_tech.model.Pedido;
import com.gympoison.projeto_tech.repository.IpedidoRepository;
import com.gympoison.projeto_tech.repository.ItemRepository;
import com.gympoison.projeto_tech.repository.PagamentoRepository;
import com.gympoison.projeto_tech.repository.PedidoRepository;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping({"/api/item_pedidos"})
public class IpedidoController {

    @Autowired
    private IpedidoRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemRepository IpedidoRepository;

    @GetMapping
    public ResponseEntity <List<Ipedido>> findAll(){
        List<Ipedido> Ipedido = repository.findAll();
        return ResponseEntity.ok(Ipedido);

    }

   @GetMapping("/{id}")
    public ResponseEntity <Ipedido> findById(@PathVariable Integer id_item_pedido){
        Ipedido itempedido = repository.findById(id_item_pedido).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

              return ResponseEntity.ok(itempedido);
    }



    @PostMapping
    public ResponseEntity <Ipedido> create(@Valid @RequestBody IpedidoRequestDTO dto) {
       Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

     Item item = ItemRepository.findById(dto.id_item())
         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));


         Ipedido Ipedido = new Ipedido();
         Ipedido.setIpedido(pedido);
         Ipedido.setid_item(item);

         Ipedido.setPreco(dto.preco());
         Ipedido.setQuantidade(dto.quantidade());


        repository.save(Ipedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(Ipedido);

    }

    @PutMapping("/{id}")
    public ResponseEntity <Ipedido> update(@PathVariable Integer id, @Valid @RequestBody ItemPedidoRequestDTO dto) {
        Ipedido Ipedido = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

        Pedido pedido = pedidoRepository.findById(dto.pedidoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

                Ipedido.setPedidoId(pedido);
                Ipedido.setProdutoId(produto);
                Ipedido.setPreco(dto.preco());
                Ipedido.setQuantidade(dto.quantidade());

        repository.save(Ipedido);
        return ResponseEntity.ok(Ipedido);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Ipedido> delete(@PathVariable Integer id){
        Ipedido Ipedido = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

        repository.delete(Ipedido);
        return ResponseEntity.noContent().build();
    }
}
