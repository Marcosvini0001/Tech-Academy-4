package com.gympoison.projeto_tech.dto;

import com.gympoison.projeto_tech.model.Pedido;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

public record PedidoRequestDTO(@NotNull Integer id_pedido, @NotNull Integer id_cliente,
                               @NotNull LocalDateTime data_pedido, @NotNull String Status_pedido,
                               @NotNull BigDecimal total_pedido, @NotNull Integer id_forma_pagamento,
                               @NotNull String endereco_entrega, String observacoes) {
}



