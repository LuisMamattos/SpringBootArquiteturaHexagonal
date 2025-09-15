package com.example.hexcrud.application.service;

import java.util.List;

import com.example.hexcrud.application.port.in.ProdutoUseCase;
import com.example.hexcrud.application.port.out.ProdutoRepositoryPort;
import com.example.hexcrud.domain.Produto;

public class ProdutoService implements ProdutoUseCase {
    private final ProdutoRepositoryPort produtoRepository;

    public ProdutoService(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Override
    public void remover(Long id) {
        produtoRepository.deleteById(id);
    }
}
