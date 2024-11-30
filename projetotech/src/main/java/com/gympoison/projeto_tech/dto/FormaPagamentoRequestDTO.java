
package com.gympoison.projeto_tech.dto;

import jakarta.persistence.Column;

public record FormaPagamentoRequestDTO(Long id,
                                       String tipoPagamento, String descricao) {
}
