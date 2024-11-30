package com.gympoison.projeto_tech.repository;

import com.gympoison.projeto_tech.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
