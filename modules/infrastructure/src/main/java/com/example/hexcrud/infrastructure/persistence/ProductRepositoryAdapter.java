package com.example.hexcrud.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Product;
import com.example.hexcrud.domain.repository.ProductRepositoryPort;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductMongoRepository repository;

    // CORRIGIDO: Agora o construtor pede a ferramenta correta (ProductMongoRepository)
    public ProductRepositoryAdapter(ProductMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) { return repository.save(product); }

    @Override
    public Optional<Product> searchById(String id) { return repository.findById(id); }

    @Override
    public List<Product> searchAll() { return repository.findAll(); }

    @Override
    public void delete(String id) { repository.deleteById(id); }

    @Override
    public Product updateProduct(String id, Product productUpdated) {
        productUpdated.setId(id);
        return repository.save(productUpdated);
    }
}