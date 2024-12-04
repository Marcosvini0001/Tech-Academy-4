package com.gympoison.projeto_tech.response;

import com.gympoison.projeto_tech.model.Pedido;

import java.time.LocalDateTime;

public record PedidoResponseDTO(Integer id_pedido, com.gympoison.projeto_tech.model.Usuario id_cliente, LocalDateTime data_pedido,
                                String status_pedido, Integer total_pedido, Integer id_forma_pagamento,
                                String endereco_entrega, String observacoes) {
    public PedidoResponseDTO(Pedido pedido) {
        this(pedido.getId_pedido(), pedido.getCliente(), pedido.getData_pedido(),
                pedido.getStatus_pedido(), pedido.getTotal_pedido(), pedido.getId_forma_pagamento(),
                pedido.getEndereco_entrega(), pedido.getObservacoes());
    }
}
