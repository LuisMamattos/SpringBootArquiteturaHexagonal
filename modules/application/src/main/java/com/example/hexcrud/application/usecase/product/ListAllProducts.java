package com.example.hexcrud.application.usecase.product;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.product.Product;
import com.example.hexcrud.domain.port.in.product.ListAllProductsUseCase;
import com.example.hexcrud.domain.port.out.product.ProductRepositoryPort;

@Component
public class ListAllProducts implements ListAllProductsUseCase {

    private final ProductRepositoryPort productRepository;

    public ListAllProducts(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> execute() {
        return productRepository.searchAll();
    }
}