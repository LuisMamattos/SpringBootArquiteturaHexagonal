package com.example.hexcrud.infrastructure.web.dto.client;

import com.example.hexcrud.domain.model.Client;

public record ClientResponse(String id, String name, String email) {
    // Método de fábrica para facilitar a conversão do modelo de domínio para o DTO
    public static ClientResponse fromDomain(Client client) {
        return new ClientResponse(client.getId(), client.getName(), client.getEmail());
    }
}