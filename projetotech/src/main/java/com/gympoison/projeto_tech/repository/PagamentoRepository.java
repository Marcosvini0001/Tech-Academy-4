package com.gympoison.projeto_tech.repository;

import com.gympoison.projeto_tech.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository  extends JpaRepository <Pagamento, Integer> {
}