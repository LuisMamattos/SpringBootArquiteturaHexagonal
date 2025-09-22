package com.example.hexcrud.infrastructure.persistence.product;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexcrud.domain.model.product.Product;

public interface ProductMongoRepository extends MongoRepository<Product, String> {}