package com.gympoison.projeto_tech.Repository;

import com.gympoison.projeto_tech.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoRepository, Integer> {
}

