package com.example.hexcrud.infrastructure.adapter.in.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexcrud.application.usecase.client.CreateClient;
import com.example.hexcrud.application.usecase.client.UpdateClient;
import com.example.hexcrud.application.usecase.client.DeleteClient;
import com.example.hexcrud.application.usecase.client.FindClientById;
import com.example.hexcrud.application.usecase.client.ListAllClients;

import com.example.hexcrud.domain.model.Client;


@RestController
@RequestMapping("/clients")
public class ClientController {

    private final CreateClient createClientUseCase;
    private final UpdateClient updateClientUseCase;
    private final DeleteClient deleteClientUseCase; 
    private final FindClientById findClientByIdUseCase;
    private final ListAllClients listAllClientsUseCase;   

     public ClientController(CreateClient createClientUseCase, UpdateClient updateClientUseCase, DeleteClient deleteClientUseCase, FindClientById findClientByIdUseCase, ListAllClients listAllClientsUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.findClientByIdUseCase = findClientByIdUseCase;
        this.listAllClientsUseCase = listAllClientsUseCase;
    }

    // MÉTODO @PostMapping REATORADO
    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        // 1. Traduz o DTO da web para o InputPort da aplicação
        var input = new CreateClient.InputPort(client.getName(), client.getEmail());

        // 2. Delega a execução para o caso de uso
        var result = createClientUseCase.execute(input);

        // 3. Traduz o OutputPort da aplicação para uma Resposta HTTP específica
        return switch (result) {
            case CreateClient.OutputPort.Created res ->
                ResponseEntity.status(HttpStatus.CREATED).body(res.client());

            case CreateClient.OutputPort.EmailAlreadyExists err ->
                ResponseEntity.status(HttpStatus.CONFLICT)
                              .body(Map.of("error", "Email already exists", "email", err.email()));
        };
    }

    // MÉTODO @GetMapping("/{id}" REATORADO
    @GetMapping("/{id}")
    public ResponseEntity<Client> searchClient(@PathVariable String id) {
        return findClientByIdUseCase.execute(id) // Usa o novo caso de uso
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // MÉTODO @GetMapping REATORADO
    @GetMapping
    public ResponseEntity<List<Client>> listClients() {
        List<Client> clients = listAllClientsUseCase.execute(); // Usa o novo caso de uso
        return ResponseEntity.ok(clients);
    }

    // MÉTODO @DeleteMapping REATORADO
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id) {
        var input = new DeleteClient.InputPort(id);
        var result = deleteClientUseCase.execute(input);

        return switch (result) {
            case DeleteClient.OutputPort.Deleted res ->
                ResponseEntity.noContent().build(); // 204 No Content é o padrão para delete com sucesso
            case DeleteClient.OutputPort.NotFound err ->
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                              .body(Map.of("error", "Client not found", "id", err.id()));
        };
    }

    // MÉTODO @PutMapping REATORADO
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable String id, @RequestBody Client clientUpdated) {
        var input = new UpdateClient.InputPort(id, clientUpdated.getName(), clientUpdated.getEmail());
        var result = updateClientUseCase.execute(input);

        // Traduz o resultado para a resposta HTTP apropriada
        return switch (result) {
            case UpdateClient.OutputPort.Updated res ->
                ResponseEntity.ok(res.client());

            case UpdateClient.OutputPort.NotFound err ->
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                              .body(Map.of("error", "Client not found", "id", err.id()));
                                 
            case UpdateClient.OutputPort.EmailAlreadyExists err ->
                ResponseEntity.status(HttpStatus.CONFLICT)
                              .body(Map.of("error", "Email already exists", "email", err.email()));
        };
    }
}
