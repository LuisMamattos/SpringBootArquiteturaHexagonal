package com.example.hexcrud.application.usecase.client;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Client;
import com.example.hexcrud.domain.port.out.ClientRepositoryPort;

@Component
public class UpdateClient {

    private final ClientRepositoryPort clientRepository;

    public UpdateClient(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

  
    public record InputPort(String id, String newName, String newEmail) {}

    //atualizado, não encontrado, ou email já em uso
    public sealed interface OutputPort {
        record Updated(Client client) implements OutputPort {}
        record NotFound(String id) implements OutputPort {}
        record EmailAlreadyExists(String email) implements OutputPort {}
    }

    public OutputPort execute(InputPort input) {
        //cliente deve existir
        Optional<Client> optionalClient = clientRepository.searchById(input.id());
        if (optionalClient.isEmpty()) {
            return new OutputPort.NotFound(input.id());
        }

        Client clientToUpdate = optionalClient.get();

        //verificar se o novo já existe em outro cliente
        if (!clientToUpdate.getEmail().equalsIgnoreCase(input.newEmail())) {
            Optional<Client> existingClientWithNewEmail = clientRepository.findByEmail(input.newEmail());
            if (existingClientWithNewEmail.isPresent()) {
                return new OutputPort.EmailAlreadyExists(input.newEmail());
            }
        }

        //atualiza e salva
        clientToUpdate.setName(input.newName());
        clientToUpdate.setEmail(input.newEmail());
        Client updatedClient = clientRepository.save(clientToUpdate);

        return new OutputPort.Updated(updatedClient);
    }
}