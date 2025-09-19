package com.example.hexcrud.domain.port.in.order;

import java.util.List;

import com.example.hexcrud.domain.model.Order;

public interface ListAllOrdersUseCase {
    List<Order> execute();
}