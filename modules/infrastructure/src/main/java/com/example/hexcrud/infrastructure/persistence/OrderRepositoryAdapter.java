package com.example.hexcrud.infrastructure.persistence;

import com.example.hexcrud.domain.model.Order;
import com.example.hexcrud.domain.repository.OrderRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {

    private final OrderMongoRepository mongoRepository;

    public OrderRepositoryAdapter(OrderMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Order save(Order order) {
        return mongoRepository.save(order);
    }
    @Override
    public Optional<Order> findById(String id) {
        return mongoRepository.findById(id);
    }
    @Override
    public List<Order> findAll() {
        return mongoRepository.findAll();
    }
}