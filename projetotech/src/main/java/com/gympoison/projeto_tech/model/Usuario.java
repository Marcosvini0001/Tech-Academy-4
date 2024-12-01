package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name = "name")
    private String nm_usuario;

    @Column
    private Integer cep_usuario;

    @Column
    private String email;

    @Column
    private String end_usuario;

    @Column
    private Integer Senha;

    public Integer getId() {
        return id_usuario;
    }

    public void setId(Integer id) {
        id_usuario = id;
    }

    public Integer getSenha() {
        return Senha;
    }

    public void setSenha(Integer senha) {
        Senha = senha;
    }

    public String getEndereco() {
        return end_usuario;
    }

    public void setEndereco(String endereco) {
        this.end_usuario = endereco;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id_usuario, usuario.id_usuario) && Objects.equals(nm_usuario, usuario.nm_usuario)
                && Objects.equals(cep_usuario, usuario.cep_usuario) && Objects.equals(email, usuario.email) && Objects.equals(end_usuario,
                usuario.end_usuario) && Objects.equals(Senha, usuario.Senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario, nm_usuario, cep_usuario, email, end_usuario, Senha);
    }
}