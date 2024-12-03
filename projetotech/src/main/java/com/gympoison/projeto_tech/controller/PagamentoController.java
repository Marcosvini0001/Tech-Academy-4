package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.PagamentoRequestDTO;
import com.gympoison.projeto_tech.model.Pagamento;
import com.gympoison.projeto_tech.model.Pedido;
import com.gympoison.projeto_tech.repository.PagamentoRepository;
import com.gympoison.projeto_tech.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping({"/api/pagamentos"})
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;


    @GetMapping
    public ResponseEntity <List<Pagamento>> findAll() {
        List <Pagamento> pagamento = repository.findAll();
        return ResponseEntity.ok(pagamento);
    }



    @GetMapping("/id_pagamento")
    public ResponseEntity <Pagamento> findById(@PathVariable Integer id_pagamento){
        Pagamento pagamento = repository.findById(id_pagamento).orElseThrow(
            
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));

        return ResponseEntity.ok(pagamento);
    }

    @PostMapping
    public ResponseEntity <Pagamento> create(@Valid @RequestBody PagamentoRequestDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));


        Pagamento pagamento = new Pagamento();
        pagamento.setId_pagamento(dto.id_pagamento());
        pagamento.setValor_pagamento(dto.valor_pagamento());
        pagamento.setData_pagamento(dto.data_pagamento());
        pagamento.setId_pedido(dto.id_pedido());


        repository.save(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);

    }

    @PutMapping("/id_item")
    public ResponseEntity <Pagamento> udate(@PathVariable Integer id_pedido,@Valid @RequestBody PagamentoRequestDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));


        Pagamento pagamento = new Pagamento();
        pagamento.setId_pagamento(dto.id_pagamento());
        pagamento.setValor_pagamento(dto.valor_pagamento());
        pagamento.setData_pagamento(dto.data_pagamento());
        pagamento.setId_pedido(dto.id_pedido());;
        repository.save(pagamento);
        return ResponseEntity.ok(pagamento);

    }

    @DeleteMapping("/id_pagamento")
    public ResponseEntity <Pagamento> delete(@PathVariable Integer id_pagamento){
        Pagamento pagamento = repository.findById(id_pagamento).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));

        repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }


}