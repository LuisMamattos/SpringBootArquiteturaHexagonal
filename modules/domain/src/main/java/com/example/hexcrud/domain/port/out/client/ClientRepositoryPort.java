package com.example.hexcrud.domain.port.out.client;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.client.Client;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> findById(String id);
    List<Client> searchAll();
    void delete(String id);
    Optional<Client> findByEmail(String email);
}
