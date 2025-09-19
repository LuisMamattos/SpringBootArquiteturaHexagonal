package com.example.hexcrud.application.usecase.client;

import java.util.Optional;

import org.springframework.stereotype.Component; // MUDANÇA

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.port.in.client.CreateClientUseCase;
import com.example.hexcrud.domain.port.out.client.ClientRepositoryPort;

@Component
public class CreateClient implements CreateClientUseCase { 

    private final ClientRepositoryPort clientRepository;

    public CreateClient(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public Output execute(Input input) {
        Optional<Client> existingClient = clientRepository.findByEmail(input.email());
        if (existingClient.isPresent()) {
            return new Output.EmailAlreadyExists(input.email());
        }

        Client newClient = new Client(input.name(), input.email());
        Client savedClient = clientRepository.save(newClient);

        return new Output.Created(savedClient);
    }
}