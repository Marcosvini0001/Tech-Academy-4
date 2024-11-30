package com.gympoison.projeto_tech.repository;


import com.gympoison.projeto_tech.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}