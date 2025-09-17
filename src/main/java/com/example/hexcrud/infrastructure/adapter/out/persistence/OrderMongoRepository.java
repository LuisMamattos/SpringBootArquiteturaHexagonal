package com.example.hexcrud.infrastructure.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexcrud.domain.model.Order; 

public interface OrderMongoRepository extends MongoRepository<Order, String> {}