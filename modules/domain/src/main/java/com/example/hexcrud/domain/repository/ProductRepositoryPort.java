package com.example.hexcrud.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> searchById(String id);
    List<Product> searchAll();
    void delete(String id);
    Product updateProduct(String id, Product productUpdated);
}
