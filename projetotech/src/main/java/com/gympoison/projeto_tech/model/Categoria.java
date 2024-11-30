package com.gympoison.projeto_tech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Categoria {

    @Column
    private String nome;

    @Column
    private Integer id;
}
