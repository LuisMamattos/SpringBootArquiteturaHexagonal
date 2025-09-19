package com.example.hexcrud.application.usecase.client;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.repository.ClientRepositoryPort;

@Component
public class DeleteClient {

    private final ClientRepositoryPort clientRepository;

    public DeleteClient(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

   
    public record InputPort(String id) {}

    //deletado ou não encontrado
    public sealed interface OutputPort {
        record Deleted() implements OutputPort {}
        record NotFound(String id) implements OutputPort {}
    }

    public OutputPort execute(InputPort input) {
        //o cliente deve existir para ser deletado
        return clientRepository.searchById(input.id())
                .map(client -> {
                    clientRepository.delete(input.id());
                    return (OutputPort) new OutputPort.Deleted();
                })
                .orElse(new OutputPort.NotFound(input.id()));
    }
}