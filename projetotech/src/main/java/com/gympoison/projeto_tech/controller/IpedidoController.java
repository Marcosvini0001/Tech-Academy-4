package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.IpedidoRequestDTO;
import com.gympoison.projeto_tech.model.Ipedido;
import com.gympoison.projeto_tech.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IpedidoController {

    @Autowired
    private PagamentoRepository repository;

    @GetMapping("/item_pedido")
    public ResponseEntity<List<Double>> findAll() {
        List<Double> pedidos = repository.findAll();
        return ResponseEntity.ok(pedidos);
    }
}
