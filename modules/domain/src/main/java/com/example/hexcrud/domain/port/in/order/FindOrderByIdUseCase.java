package com.example.hexcrud.domain.port.in.order;
import java.util.Optional;

import com.example.hexcrud.domain.model.order.Order;
public interface FindOrderByIdUseCase {
    Optional<Order> execute(String orderId);
}