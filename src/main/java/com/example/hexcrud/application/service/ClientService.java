package com.example.hexcrud.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.port.in.ClientUseCase;
import com.example.hexcrud.domain.port.out.ClientRepositoryPort;

@Service
public class ClientService implements ClientUseCase {

    private final ClientRepositoryPort repository;

    public ClientService(ClientRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Client createClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Optional<Client> searchClient(String id) {
        return repository.searchById(id);
    }

    @Override
    public List<Client> listClients() {
        return repository.searchAll();
    }

    @Override
    public void deleteClient(String id) {
        repository.delete(id);
    }
    @Override
    public Client updateClient(String id, Client clientUpdated) {
        
        return repository.updateClient(id, clientUpdated);
    }
    
}
