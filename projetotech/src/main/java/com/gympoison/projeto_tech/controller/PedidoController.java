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
    public ResponseEntity<Pedido> save(@Valid @RequestBody PedidoRequestDTO dto) {
        Usuario usuario = repositoryUsuario.findById(dto.id_cliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        Pedido pedido = new Pedido();
        pedido.setid_cliente(dto.id_cliente());
        pedido.setid_cliente(dto.id_cliente());
        pedido.setstatus_pedido(dto.Status_pedido());
        pedido.settotal_pedido(dto.total_pedido());


        this.repository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

    }

    @DeleteMapping("/id_pedido")
    public ResponseEntity<Void> delete(@PathVariable Integer id_cliente){
        Pedido pedido  = repository.findById(id_cliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id_cliente")
    public ResponseEntity<Pedido> update(@PathVariable Integer id_pedido,@Valid @RequestBody PedidoRequestDTO dto){
        Pedido pedido = repository.findById(id_pedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Usuario usuario = repositoryUsuario.findById(dto.id_cliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

            pedido.setid_cliente(dto.id_cliente());
            pedido.setid_cliente(dto.id_cliente());
            pedido.setstatus_pedido(dto.Status_pedido());
            pedido.settotal_pedido(dto.total_pedido());

        repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}