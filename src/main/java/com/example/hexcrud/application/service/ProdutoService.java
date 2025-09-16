package com.example.hexcrud.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hexcrud.domain.model.Produto;
import com.example.hexcrud.domain.port.in.ProdutoUseCase;
import com.example.hexcrud.domain.port.out.ProdutoRepositoryPort;

@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoRepositoryPort repository;

    public ProdutoService(ProdutoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return repository.salvar(produto);
    }

    @Override
    public Optional<Produto> buscarProduto(String id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Produto> listarProdutos() {
        return repository.buscarTodos();
    }

    @Override
    public void deletarProduto(String id) {
        repository.deletar(id);
    }
    @Override
    public Produto atualizarProduto(String id, Produto produtoAtualizado) {        
        return repository.atualizarProduto(id, produtoAtualizado);
    }
}
