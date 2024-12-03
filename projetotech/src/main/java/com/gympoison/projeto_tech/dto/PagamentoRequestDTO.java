package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;


public record PagamentoRequestDTO(@NotBlank Integer id_forma_pagamento,
                                    @NotBlank Enum status_pagamento,
                                    @NotBlank BigDecimal valor_pagamento,
                                    @NotBlank Date data_pagamento,
                                    @NotBlank Integer id_pedido,
                                    @NotBlank Integer id_pagamento)


{
}
