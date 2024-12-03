
package com.gympoison.projeto_tech.dto;


import jakarta.validation.constraints.NotNull;

public record FormaPagamentoRequestDTO(@NotNull Integer id_forma_pagamento,
                                       @NotNull String tipo_pagamento, @NotNull String descricao) {
}
