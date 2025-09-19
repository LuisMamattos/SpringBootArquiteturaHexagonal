package com.example.hexcrud.infrastructure.persistence;

import com.example.hexcrud.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Product, String> {}