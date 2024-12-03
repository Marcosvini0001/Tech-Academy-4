package com.gympoison.projeto_tech.controller;


import com.gympoison.projeto_tech.dto.PedidoRequestDTO;
import com.gympoison.projeto_tech.model.Pedido;
import com.gympoison.projeto_tech.model.Usuario;
import com.gympoison.projeto_tech.repository.UsuarioRepository;
import com.gympoison.projeto_tech.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/id_pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private UsuarioRepository repositoryUsuario;


    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedido = repository.findAll();
        return ResponseEntity.ok(pedido);

    }

    @GetMapping("/id_pedido")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id_pedido) {
        Pedido pedido = repository.findById(id_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@PathVariable Integer id_pedido,@Valid @RequestBody PedidoRequestDTO dto) {

        Pedido pedido = new Pedido();
        pedido.getid_pedido(dto.id_pedido());
        pedido.setid_cliente(dto.id_cliente());
        pedido.setstatus_pedido(dto.Status_pedido());
        pedido.settotal_pedido(dto.total_pedido());
        pedido.getdata_pedido(dto.data_pedido());
        pedido.getid_forma_pagamento(dto.id_forma_pagamento());
        pedido.getendereco_entrega(dto.endereco_entrega());
        pedido.getobservacoes(dto.observacoes());


        this.repository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

    }

    @DeleteMapping("/id_pedido")
    public ResponseEntity<Void> delete(@PathVariable Integer id_pedido,@Valid @RequestBody PedidoRequestDTO dto){
        Pedido pedido  = repository.findById(id_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        pedido.getid_pedido(dto.id_pedido());
        pedido.setid_cliente(dto.id_cliente());
        pedido.setstatus_pedido(dto.Status_pedido());
        pedido.settotal_pedido(dto.total_pedido());
        pedido.getdata_pedido(dto.data_pedido());
        pedido.getid_forma_pagamento(dto.id_forma_pagamento());
        pedido.getendereco_entrega(dto.endereco_entrega());
        pedido.getobservacoes(dto.observacoes());

        repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id_pedido")
    public ResponseEntity<Pedido> update(@PathVariable Integer id_pedido,@Valid @RequestBody PedidoRequestDTO dto){
        Pedido pedido = repository.findById(id_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        pedido.getid_pedido(dto.id_pedido());
        pedido.setid_cliente(dto.id_cliente());
        pedido.setstatus_pedido(dto.Status_pedido());
        pedido.settotal_pedido(dto.total_pedido());
        pedido.getdata_pedido(dto.data_pedido());
        pedido.getid_forma_pagamento(dto.id_forma_pagamento());
        pedido.getendereco_entrega(dto.endereco_entrega());
        pedido.getobservacoes(dto.observacoes());

        repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}