package com.example.hexcrud.domain.port.in.client;

import java.util.Optional;

import com.example.hexcrud.domain.model.client.Client;

public interface FindClientByIdUseCase {
    Optional<Client> execute(String id);
}