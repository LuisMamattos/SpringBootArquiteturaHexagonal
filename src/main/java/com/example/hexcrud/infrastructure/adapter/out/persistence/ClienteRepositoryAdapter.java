package com.example.hexcrud.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.application.port.out.ClienteRepositoryPort;
import com.example.hexcrud.domain.Cliente;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {
    private final ClienteJpaRepository repository;

    public ClienteRepositoryAdapter(ClienteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(new ClienteJpaEntity(cliente)).toDomain();
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll().stream().map(ClienteJpaEntity::toDomain).toList();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id).map(ClienteJpaEntity::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
