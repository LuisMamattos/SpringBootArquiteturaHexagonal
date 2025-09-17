package com.example.hexcrud.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.port.out.ClientRepositoryPort;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientMongoRepository repository;

    public ClientRepositoryAdapter(ClientMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) { return repository.save(client); }

    @Override
    public Optional<Client> searchById(String id) { return repository.findById(id); }

    @Override
    public List<Client> searchAll() { return repository.findAll(); }

    @Override
    public void delete(String id) { repository.deleteById(id); }
    
    @Override
    public Client updateClient(String id, Client clientUpdated) {
        clientUpdated.setId(id);
        return repository.save(clientUpdated);
    }
    
}
