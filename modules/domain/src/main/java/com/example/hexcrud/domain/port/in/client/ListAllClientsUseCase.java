package com.example.hexcrud.domain.port.in.client;

import java.util.List;

import com.example.hexcrud.domain.model.Client;

public interface ListAllClientsUseCase {
    List<Client> execute();
}