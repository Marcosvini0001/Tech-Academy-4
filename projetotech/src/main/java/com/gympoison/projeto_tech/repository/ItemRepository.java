package com.gympoison.projeto_tech.repository;


import com.gympoison.projeto_tech.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}