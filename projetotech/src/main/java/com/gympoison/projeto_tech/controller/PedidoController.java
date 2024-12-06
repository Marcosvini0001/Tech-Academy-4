package com.gympoison.projeto_tech.controller;

import com.gympoison.projeto_tech.dto.PedidoRequestDTO;
import com.gympoison.projeto_tech.model.Pedido;
import com.gympoison.projeto_tech.model.Usuario;
import com.gympoison.projeto_tech.repository.UsuarioRepository;
import com.gympoison.projeto_tech.response.PedidoResponseDTO;
import com.gympoison.projeto_tech.repository.PedidoRepository;
import com.gympoison.projeto_tech.response.UsuarioResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<PedidoResponseDTO> responseDTOList = pedidos.stream()
                .map(PedidoResponseDTO::new)
                .toList();
        return ResponseEntity.ok(responseDTOList);
    }


    @GetMapping("/{id_pedido}")
    public ResponseEntity<PedidoResponseDTO> findById(@PathVariable Integer id_pedido) {
        Pedido pedido = pedidoRepository.findById(id_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        return ResponseEntity.ok(new PedidoResponseDTO(pedido));
    }


    @PostMapping
    public ResponseEntity<Pedido> save(@Valid @RequestBody PedidoRequestDTO dto) {
        Usuario cliente = usuarioRepository.findById(dto.id_cliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setId_pedido(dto.id_pedido());
        pedido.setCliente(cliente);
        pedido.setData_pedido(dto.data_pedido());
        pedido.setStatus_pedido(dto.Status_pedido());
        pedido.setTotal_pedido(dto.total_pedido());
        pedido.setId_forma_pagamento(dto.id_forma_pagamento());
        pedido.setEndereco_entrega(dto.endereco_entrega());
        pedido.setObservacoes(dto.observacoes());

        this.pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }


    @PutMapping("/{id_pedido}")
    public ResponseEntity<Pedido> update(@PathVariable Integer id_pedido, @Valid @RequestBody PedidoRequestDTO dto) {
        Pedido pedido = pedidoRepository.findById(id_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Usuario cliente = usuarioRepository.findById(dto.id_cliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        pedido.setCliente(cliente);
        pedido.setData_pedido(dto.data_pedido());
        pedido.setStatus_pedido(dto.Status_pedido());
        pedido.setTotal_pedido(dto.total_pedido());
        pedido.setId_forma_pagamento(dto.id_forma_pagamento());
        pedido.setEndereco_entrega(dto.endereco_entrega());
        pedido.setObservacoes(dto.observacoes());

        pedidoRepository.save(pedido);
        return ResponseEntity.ok(pedido);
    }


    @DeleteMapping("/{id_pedido}")
    public ResponseEntity<Void> delete(@PathVariable Integer id_pedido, @Valid @RequestBody PedidoRequestDTO dto) {
        Pedido pedido = pedidoRepository.findById(id_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        Usuario cliente = usuarioRepository.findById(dto.id_cliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        pedido.setCliente(cliente);
        pedido.setData_pedido(dto.data_pedido());
        pedido.setStatus_pedido(dto.Status_pedido());
        pedido.setTotal_pedido(dto.total_pedido());
        pedido.setId_forma_pagamento(dto.id_forma_pagamento());
        pedido.setEndereco_entrega(dto.endereco_entrega());
        pedido.setObservacoes(dto.observacoes());

        pedidoRepository.delete(pedido);
        return ResponseEntity.noContent().build();
    }
}

