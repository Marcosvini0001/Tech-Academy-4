package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_usuario;

    @Column(name = "name")
    private String nome;

    @Column
    private Integer cep;

    @Column
    private String email;

    @Column
    private String endereco;

    @Column
    private Integer Senha;

    public Integer getId() {
        return Id_usuario;
    }

    public void setId(Integer id) {
        Id_usuario = id;
    }

    public Integer getSenha() {
        return Senha;
    }

    public void setSenha(Integer senha) {
        Senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(Id_usuario, usuario.Id_usuario) && Objects.equals(nome, usuario.nome) && Objects.equals(cep, usuario.cep) && Objects.equals(email, usuario.email) && Objects.equals(endereco, usuario.endereco) && Objects.equals(Senha, usuario.Senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_usuario, nome, cep, email, endereco, Senha);
    }
}
