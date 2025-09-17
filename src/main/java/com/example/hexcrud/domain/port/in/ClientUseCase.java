package com.example.hexcrud.domain.port.in;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Client;

public interface ClientUseCase {
    Client createClient(Client client);
    Optional<Client> searchClient(String id);
    List<Client> listClients();
    void deleteClient(String id);
    Client updateClient(String id, Client clientUpdated);
}
