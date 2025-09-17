package com.example.hexcrud.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hexcrud.domain.model.Order;
import com.example.hexcrud.domain.port.in.OrderUseCase;
import com.example.hexcrud.domain.port.out.OrderRepositoryPort;

import java.time.LocalDateTime;

@Service
public class OrderService implements OrderUseCase {

    private final OrderRepositoryPort orderRepository;

    public OrderService(OrderRepositoryPort orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Order createOrder(Order order) {        
        double totalPrice = order.getProducts().stream()
                               .mapToDouble(p -> p.getPrice())
                               .sum();
        order.setTotalPrice(totalPrice);        
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }
    @Override
    public Optional<Order> findOrderById(String id) {
        return orderRepository.findById(id);
    }
    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}