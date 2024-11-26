package com.gympoison.projeto_tech.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<com.exemplo.produto.model.Produto, Integer> {
}