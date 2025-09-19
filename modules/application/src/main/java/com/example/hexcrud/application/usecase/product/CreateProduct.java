package com.example.hexcrud.application.usecase.product;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Product;
import com.example.hexcrud.domain.port.in.product.CreateProductUseCase;
import com.example.hexcrud.domain.port.out.product.ProductRepositoryPort;

@Component
public class CreateProduct implements CreateProductUseCase {
    private final ProductRepositoryPort productRepository;

    public CreateProduct(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(Input input) {
        Product newProduct = new Product(input.name(), input.price());
        return productRepository.save(newProduct);
    }
}