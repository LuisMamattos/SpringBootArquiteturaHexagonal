package com.example.hexcrud.application.usecase.order;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexcrud.domain.model.Order;
import com.example.hexcrud.domain.port.in.order.FindOrderByIdUseCase;
import com.example.hexcrud.domain.port.out.order.OrderRepositoryPort;

@Component
public class FindOrderById implements FindOrderByIdUseCase {
    private final OrderRepositoryPort orderRepository;

    public FindOrderById(OrderRepositoryPort orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> execute(String orderId) {
        return orderRepository.findById(orderId);
    }
}