package com.gympoison.projeto_tech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Categoria {

    @Column
    private String nome;

    @Column
    private Integer id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
