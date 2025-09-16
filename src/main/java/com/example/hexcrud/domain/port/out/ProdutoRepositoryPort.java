package com.example.hexcrud.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Produto;



public interface ProdutoRepositoryPort {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(String id);
    List<Produto> buscarTodos();
    void deletar(String id);
}
