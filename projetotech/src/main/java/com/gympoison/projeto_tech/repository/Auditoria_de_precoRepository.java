package com.gympoison.projeto_tech.repository;

import com.gympoison.projeto_tech.model.Auditoria_de_preco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Auditoria_de_precoRepository extends JpaRepository<Auditoria_de_preco, Integer> {
}

