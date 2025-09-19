package com.example.hexcrud.application.usecase.order;

import com.example.hexcrud.domain.model.Order;
import com.example.hexcrud.domain.port.in.order.CreateOrderUseCase;
import com.example.hexcrud.domain.port.out.client.ClientRepositoryPort;
import com.example.hexcrud.domain.port.out.order.OrderRepositoryPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class CreateOrder implements CreateOrderUseCase {
    private final OrderRepositoryPort orderRepository;
    private final ClientRepositoryPort clientRepository;

    public CreateOrder(OrderRepositoryPort orderRepository, ClientRepositoryPort clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public Order execute(Input input) {
        clientRepository.findById(input.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + input.clientId()));

        Order newOrder = Order.create(input.clientId());
        return orderRepository.save(newOrder);
    }
}