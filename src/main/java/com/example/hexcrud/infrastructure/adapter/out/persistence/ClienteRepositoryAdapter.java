package com.example.hexcrud.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Cliente;
import com.example.hexcrud.domain.port.out.ClienteRepositoryPort;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteMongoRepository repository;

    public ClienteRepositoryAdapter(ClienteMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salvar(Cliente cliente) { return repository.save(cliente); }

    @Override
    public Optional<Cliente> buscarPorId(String id) { return repository.findById(id); }

    @Override
    public List<Cliente> buscarTodos() { return repository.findAll(); }

    @Override
    public void deletar(String id) { repository.deleteById(id); }

    public Cliente atualizarCliente(String id, Cliente clienteAtualizado) {
        clienteAtualizado.setId(id);
        return repository.save(clienteAtualizado);
    }
    
}
