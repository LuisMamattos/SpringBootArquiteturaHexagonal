package com.example.hexcrud.application.usecase.client;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.repository.ClientRepositoryPort;

@Component
public class CreateClient {

    private final ClientRepositoryPort clientRepository;

    public CreateClient(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

    
    public record InputPort(String name, String email) {}

    //sucesso ou erro
    public sealed interface OutputPort {
        record Created(Client client) implements OutputPort {}
        record EmailAlreadyExists(String email) implements OutputPort {}
    }

    
    public OutputPort execute(InputPort input) {
        //verifica se o email já existe
        Optional<Client> existingClient = clientRepository.findByEmail(input.email());
        if (existingClient.isPresent()) {
            return new OutputPort.EmailAlreadyExists(input.email());
        }

        Client newClient = new Client(input.name(), input.email());
        Client savedClient = clientRepository.save(newClient);

        return new OutputPort.Created(savedClient);
    }
}