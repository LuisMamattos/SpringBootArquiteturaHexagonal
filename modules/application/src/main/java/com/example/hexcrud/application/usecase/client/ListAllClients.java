package com.example.hexcrud.application.usecase.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.repository.ClientRepositoryPort;

@Component
public class ListAllClients {

    private final ClientRepositoryPort clientRepository;

    public ListAllClients(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> execute() {
        return clientRepository.searchAll();
    }
}