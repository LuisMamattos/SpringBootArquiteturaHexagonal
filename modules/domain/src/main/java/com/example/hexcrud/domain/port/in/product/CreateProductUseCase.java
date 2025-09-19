package com.example.hexcrud.domain.port.in.product;

import com.example.hexcrud.domain.model.Product;

public interface CreateProductUseCase {
    record Input(String name, double price) {}
    Product execute(Input input);
}