package com.example.hexcrud.domain.port.in;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Produto;

public interface ProdutoUseCase {
    Produto criarProduto(Produto produto);
    Optional<Produto> buscarProduto(String id);
    List<Produto> listarProdutos();
    void deletarProduto(String id);
}
