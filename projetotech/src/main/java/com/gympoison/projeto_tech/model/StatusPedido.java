package com.gympoison.projeto_tech.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedido {
    ATIVO("ativo"),
    INATIVO("inativo"),
    PENDENTE("pendente");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }


    @JsonCreator
    public static StatusPedido fromStatus(String status) {
        for (StatusPedido statusPedido : StatusPedido.values()) {
            if (statusPedido.status.equals(status)) {
                return statusPedido;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + status);
    }
}

