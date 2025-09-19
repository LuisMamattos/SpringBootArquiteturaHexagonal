package com.example.hexcrud.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.port.out.client.ClientRepositoryPort;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientMongoRepository repository;

    public ClientRepositoryAdapter(ClientMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) { return repository.save(client); }

    @Override
    public Optional<Client> findById(String id) { return repository.findById(id); }

    @Override
    public List<Client> searchAll() { return repository.findAll(); }

    @Override
    public void delete(String id) { repository.deleteById(id); }

    @Override
    public Optional<Client> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}