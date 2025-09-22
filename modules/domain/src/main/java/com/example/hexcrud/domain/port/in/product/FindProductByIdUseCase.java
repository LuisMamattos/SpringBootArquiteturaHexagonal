package com.example.hexcrud.domain.port.in.product;

import java.util.Optional;

import com.example.hexcrud.domain.model.product.Product;

public interface FindProductByIdUseCase {
    Optional<Product> execute(String id);
}