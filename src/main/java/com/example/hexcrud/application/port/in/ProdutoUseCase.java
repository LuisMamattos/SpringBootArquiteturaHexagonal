package com.example.hexcrud.application.port.in;

import java.util.List;

import com.example.hexcrud.domain.Produto;

public interface ProdutoUseCase {
    Produto cadastrar(Produto produto);
    List<Produto> listar();
    Produto buscarPorId(Long id);
    void remover(Long id);
}
