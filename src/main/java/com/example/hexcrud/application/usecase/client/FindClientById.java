package com.example.hexcrud.application.usecase.client;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.port.out.ClientRepositoryPort;

@Component
public class FindClientById {

    private final ClientRepositoryPort clientRepository;

    public FindClientById(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> execute(String id) {
        return clientRepository.searchById(id);
    }
}