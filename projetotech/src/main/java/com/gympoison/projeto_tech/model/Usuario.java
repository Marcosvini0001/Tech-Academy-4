package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name = "nm_usuario")
    private String nm_usuario;

    @Column
    private Integer cep_usuario;

    @Column
    private String email;

    @Column
    private String end_usuario;

    @Column
    private String senha;

    // Getters e Setters
    public Integer getId() {
        return id_usuario;
    }

    public void setId(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return end_usuario;
    }

    public void setEndereco(String end_usuario) {
        this.end_usuario = end_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCep() {
        return cep_usuario;
    }

    public void setCep(Integer cep) {
        this.cep_usuario = cep;
    }

    public String getNome() {
        return nm_usuario;
    }

    public void setNome(String nome) {
        this.nm_usuario = nome;
    }


}
