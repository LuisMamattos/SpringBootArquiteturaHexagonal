package com.example.hexcrud.domain.port.in.order;
import com.example.hexcrud.domain.model.Order;
public interface AddItemToOrderUseCase {
    record Input(String orderId, String productId, int quantity) {}
    Order execute(Input input);
}