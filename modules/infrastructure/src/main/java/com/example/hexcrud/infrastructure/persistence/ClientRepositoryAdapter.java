package com.example.hexcrud.infrastructure.persistence;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.repository.ClientRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Client> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}