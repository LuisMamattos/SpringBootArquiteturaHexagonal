package com.example.hexcrud.domain.port.in;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Order;

public interface OrderUseCase {   
    Order createOrder(Order order);
    Optional<Order> findOrderById(String id);
    List<Order> findAllOrders();
}