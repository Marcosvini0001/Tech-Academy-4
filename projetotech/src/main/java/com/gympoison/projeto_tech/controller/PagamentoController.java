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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pagamentos") // Ajuste a URL base
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = repository.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/id_pagamento")
    public ResponseEntity<Pagamento> findById(@PathVariable Integer id_pagamento) {
        Pagamento pagamento = repository.findById(id_pagamento)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));
        return ResponseEntity.ok(pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> create(@Valid @RequestBody PagamentoRequestDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Pagamento pagamento = new Pagamento();
        pagamento.setValor_pagamento(dto.valor_pagamento());
        pagamento.setData_pagamento(LocalDate.from(dto.data_pagamento()));
        pagamento.setPedido(pedido);
        repository.save(pagamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    @PutMapping("/id_pagamento")
    public ResponseEntity<Pagamento> update(@PathVariable Integer id_pagamento, @Valid @RequestBody PagamentoRequestDTO dto) {
        Pagamento pagamento = repository.findById(id_pagamento)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));

        Pedido pedido = pedidoRepository.findById(dto.id_pedido())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        pagamento.setValor_pagamento(dto.valor_pagamento());
        pagamento.setData_pagamento(LocalDate.from(dto.data_pagamento()));
        pagamento.setPedido(pedido);
        repository.save(pagamento);

        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/id_pagamento")
    public ResponseEntity<Void> delete(@PathVariable Integer id_pagamento) {
        Pagamento pagamento = repository.findById(id_pagamento)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado"));

        repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }
}
