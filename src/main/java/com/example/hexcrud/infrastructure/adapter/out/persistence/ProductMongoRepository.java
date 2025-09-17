package com.example.hexcrud.infrastructure.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexcrud.domain.model.Product;

public interface ProductMongoRepository extends MongoRepository<Product, String> {}
