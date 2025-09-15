package com.example.hexcrud.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.application.port.out.ProdutoRepositoryPort;
import com.example.hexcrud.domain.Produto;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {
    private final ProdutoJpaRepository repository;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto save(Produto produto) {
        return repository.save(new ProdutoJpaEntity(produto)).toDomain();
    }

    @Override
    public List<Produto> findAll() {
        return repository.findAll().stream().map(ProdutoJpaEntity::toDomain).toList();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return repository.findById(id).map(ProdutoJpaEntity::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
