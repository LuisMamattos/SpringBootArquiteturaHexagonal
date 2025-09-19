package com.example.hexcrud.application.usecase.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.port.in.client.ListAllClientsUseCase;
import com.example.hexcrud.domain.port.out.client.ClientRepositoryPort;

@Component
public class ListAllClients implements ListAllClientsUseCase { 

    private final ClientRepositoryPort clientRepository;

    public ListAllClients(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override 
    public List<Client> execute() {
        return clientRepository.searchAll();
    }
}