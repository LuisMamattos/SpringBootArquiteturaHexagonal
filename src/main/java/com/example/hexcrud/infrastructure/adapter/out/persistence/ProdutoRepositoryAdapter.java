package com.example.hexcrud.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Produto;
import com.example.hexcrud.domain.port.out.ProdutoRepositoryPort;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoMongoRepository repository;

    public ProdutoRepositoryAdapter(ProdutoMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto salvar(Produto produto) { return repository.save(produto); }

    @Override
    public Optional<Produto> buscarPorId(String id) { return repository.findById(id); }

    @Override
    public List<Produto> buscarTodos() { return repository.findAll(); }

    @Override
    public void deletar(String id) { repository.deleteById(id); }

    @Override
    public Produto atualizarProduto(String id, Produto produtoAtualizado) {
        produtoAtualizado.setId(id);
        return repository.save(produtoAtualizado);
    }


}
