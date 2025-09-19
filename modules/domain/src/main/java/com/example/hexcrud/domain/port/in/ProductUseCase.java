package com.example.hexcrud.domain.port.in;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Product;

public interface ProductUseCase {
    Product createProduct(Product product);
    Optional<Product> searchProduct(String id);
    List<Product> listProducts();
    void deleteProduct(String id);
    Product updateProduct(String id, Product productUpdated);
}
