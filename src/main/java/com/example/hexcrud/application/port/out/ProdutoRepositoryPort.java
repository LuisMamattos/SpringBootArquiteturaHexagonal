
package com.example.hexcrud.application.port.out;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.Produto;

public interface ProdutoRepositoryPort {
    Produto save(Produto produto);
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    void deleteById(Long id);
}
