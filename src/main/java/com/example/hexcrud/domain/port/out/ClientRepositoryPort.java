package com.example.hexcrud.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Client;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> searchById(String id);
    List<Client> searchAll();
    void delete(String id);
    Client updateClient(String id, Client clientUpdated);
    
}
