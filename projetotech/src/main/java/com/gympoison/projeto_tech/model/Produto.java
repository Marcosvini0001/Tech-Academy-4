package com.gympoison.projeto_tech.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Produto {

    @Column(name = "name")
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private BigDecimal valor;

    @Column
    private String descricao;
}
