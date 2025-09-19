package com.example.hexcrud.domain.port.in.order;
import com.example.hexcrud.domain.model.Order;
public interface CreateOrderUseCase {
    record Input(String clientId) {}
    Order execute(Input input);
}