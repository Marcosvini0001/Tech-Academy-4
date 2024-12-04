package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false) // Relacionamento com a tabela de usuários
    private Usuario cliente;

    @Column(nullable = false)
    private LocalDateTime data_pedido;

    @Column
    private String status_pedido;

    @Column
    private Integer total_pedido;

    @Column
    private Integer id_forma_pagamento;

    @Column
    private String endereco_entrega;

    @Column
    private String observacoes;

    // Getters e Setters
    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(String status_pedido) {
        this.status_pedido = status_pedido;
    }

    public Integer getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(Integer total_pedido) {
        this.total_pedido = total_pedido;
    }

    public Integer getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(Integer id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getEndereco_entrega() {
        return endereco_entrega;
    }

    public void setEndereco_entrega(String endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
