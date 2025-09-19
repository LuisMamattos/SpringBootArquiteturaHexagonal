package com.example.hexcrud.infrastructure.persistence;

import com.example.hexcrud.domain.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderMongoRepository extends MongoRepository<Order, String> {}