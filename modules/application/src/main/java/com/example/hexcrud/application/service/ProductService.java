package com.example.hexcrud.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hexcrud.domain.model.Product;
import com.example.hexcrud.domain.port.in.ProductUseCase;
import com.example.hexcrud.domain.repository.ProductRepositoryPort;

@Service
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort repository;

    public ProductService(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> searchProduct(String id) {
        return repository.searchById(id);
    }

    @Override
    public List<Product> listProducts() {
        return repository.searchAll();
    }

    @Override
    public void deleteProduct(String id) {
        repository.delete(id);
    }
    @Override
    public Product updateProduct(String id, Product productUpdated) {        
        return repository.updateProduct(id, productUpdated);
    }
}
