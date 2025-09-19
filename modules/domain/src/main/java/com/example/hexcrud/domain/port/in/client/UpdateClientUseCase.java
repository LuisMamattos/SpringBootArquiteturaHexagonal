package com.example.hexcrud.domain.port.in.client;

import com.example.hexcrud.domain.model.Client;

public interface UpdateClientUseCase {
    
    record Input(String id, String newName, String newEmail) {}

    sealed interface Output {
        record Updated(Client client) implements Output {}
        record NotFound(String id) implements Output {}
        record EmailAlreadyExists(String email) implements Output {}
    }

    Output execute(Input input);
}
