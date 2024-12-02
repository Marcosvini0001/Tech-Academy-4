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
    private IpedidoRepository IpedidoRepository;

    @GetMapping
    public ResponseEntity <List<Ipedido>> findAll(){
        List<Ipedido> Ipedido = repository.findAll(); // Erro aqui
        return ResponseEntity.ok(Ipedido);

    }

   @GetMapping("/{id}")
    public ResponseEntity <Ipedido> findById(@PathVariable Integer id_item_pedido){
        Ipedido Ipedido = repository.findById(id_item_pedido).orElseThrow( // Erro aqui em (id_item_pedido)
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

              return ResponseEntity.ok(Ipedido);
    }



    @PostMapping
    public ResponseEntity <Ipedido> create(@Valid @RequestBody IpedidoRequestDTO dto) {
       Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

     Item item = ItemRepository.findById(dto.id_pedido()) // Erro aqui em findById
         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));


         Ipedido Ipedido = new Ipedido();
         Ipedido.setId_item_pedido(dto.id_item_pedido());
         Ipedido.setId_pedido(dto.id_pedido());

         Ipedido.setPreco_unitario(dto.preco_unitario());
         Ipedido.setQuantidade(dto.quantidade());


        repository.save(Ipedido); // Erro aqui
        return ResponseEntity.status(HttpStatus.CREATED).body(Ipedido);

    }

    @PutMapping("/{id}")
    public ResponseEntity <Ipedido> update(@PathVariable Integer id, @Valid @RequestBody IpedidoRequestDTO dto) {
        Ipedido Ipedido = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado"));

        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Item item = ItemRepository.findById(dto.id_produto()) // Erro aqui em findById
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

                Ipedido.setId_pedido(dto.id_pedido());
                Ipedido.setId_produto(dto.id_produto());
                Ipedido.setPreco_unitario(dto.preco_unitario());
                Ipedido.setTotal_item(dto.total_item());

        repository.save(Ipedido); // Erro aqui
        return ResponseEntity.ok(Ipedido);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Ipedido> delete(@PathVariable Double id_item_pedido ){
        Ipedido Ipedido = repository.findById(id_item_pedido).orElseThrow( // Erro aqui
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item do pedido não encontrado")); // Erro aqui

        repository.delete(Ipedido); // Erro aqui em (Ipedido)
        return ResponseEntity.noContent().build();
    }
}
