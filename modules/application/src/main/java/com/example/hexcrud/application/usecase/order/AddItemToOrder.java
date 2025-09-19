package com.example.hexcrud.application.usecase.order;

import com.example.hexcrud.domain.model.Order;
import com.example.hexcrud.domain.model.Product;
import com.example.hexcrud.domain.port.in.order.AddItemToOrderUseCase;
import com.example.hexcrud.domain.port.out.order.OrderRepositoryPort;
import com.example.hexcrud.domain.port.out.product.ProductRepositoryPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AddItemToOrder implements AddItemToOrderUseCase {

    private final OrderRepositoryPort orderRepository;
    private final ProductRepositoryPort productRepository;

    public AddItemToOrder(OrderRepositoryPort orderRepository, ProductRepositoryPort productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Order execute(Input input) {
        Order order = orderRepository.findById(input.orderId())
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + input.orderId()));

        Product product = productRepository.findById(input.productId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + input.productId()));

        order.addItem(product, input.quantity());

        return orderRepository.save(order);
    }
}