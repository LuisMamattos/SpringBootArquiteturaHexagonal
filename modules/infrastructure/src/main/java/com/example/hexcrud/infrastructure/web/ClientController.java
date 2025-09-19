package com.example.hexcrud.infrastructure.web;

import com.example.hexcrud.api.dto.request.CreateClientRequest;
import com.example.hexcrud.application.usecase.client.*;
import com.example.hexcrud.domain.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final CreateClient createClientUseCase;
    private final UpdateClient updateClientUseCase;
    private final DeleteClient deleteClientUseCase;
    private final FindClientById findClientByIdUseCase;
    private final ListAllClients listAllClientsUseCase;

    public ClientController(CreateClient createClientUseCase, UpdateClient updateClientUseCase,
                            DeleteClient deleteClientUseCase, FindClientById findClientByIdUseCase,
                            ListAllClients listAllClientsUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.findClientByIdUseCase = findClientByIdUseCase;
        this.listAllClientsUseCase = listAllClientsUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody CreateClientRequest request) {
        var input = new CreateClient.InputPort(request.name(), request.email());
        var result = createClientUseCase.execute(input);
        return switch (result) {
            case CreateClient.OutputPort.Created res -> ResponseEntity.status(HttpStatus.CREATED).body(res.client());
            case CreateClient.OutputPort.EmailAlreadyExists err -> ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Email already exists", "email", err.email()));
        };
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable String id, @RequestBody Client clientUpdated) {
        var input = new UpdateClient.InputPort(id, clientUpdated.getName(), clientUpdated.getEmail());
        var result = updateClientUseCase.execute(input);
        return switch (result) {
            case UpdateClient.OutputPort.Updated res -> ResponseEntity.ok(res.client());
            case UpdateClient.OutputPort.NotFound err -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Client not found", "id", err.id()));
            case UpdateClient.OutputPort.EmailAlreadyExists err -> ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Email already exists", "email", err.email()));
        };
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id) {
        var input = new DeleteClient.InputPort(id);
        var result = deleteClientUseCase.execute(input);
        return switch (result) {
            case DeleteClient.OutputPort.Deleted res -> ResponseEntity.noContent().build();
            case DeleteClient.OutputPort.NotFound err -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Client not found", "id", err.id()));
        };
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchClient(@PathVariable String id) {
        return findClientByIdUseCase.execute(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Client>> listClients() {
        List<Client> clients = listAllClientsUseCase.execute();
        return ResponseEntity.ok(clients);
    }
}