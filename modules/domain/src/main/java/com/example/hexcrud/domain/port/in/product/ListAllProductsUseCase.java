package com.example.hexcrud.domain.port.in.product;

import java.util.List;

import com.example.hexcrud.domain.model.Product;

public interface ListAllProductsUseCase {
    List<Product> execute();
}