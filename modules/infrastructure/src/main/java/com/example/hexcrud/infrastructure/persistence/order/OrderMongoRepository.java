package com.example.hexcrud.infrastructure.persistence.order;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexcrud.domain.model.order.Order;

public interface OrderMongoRepository extends MongoRepository<Order, String> {}