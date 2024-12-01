package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotBlank;


public record PagamentoRequestDTO(@NotBlank Double id_forma_pagamento,
                                    @NotBlank String status_pagamento,
                                    @NotBlank Double valor_pagamento,
                                    @NotBlank Double data_pagamento,
                                    @NotBlank Double id_pedido,
                                    @NotBlank Double id_pagamento)


{
}
