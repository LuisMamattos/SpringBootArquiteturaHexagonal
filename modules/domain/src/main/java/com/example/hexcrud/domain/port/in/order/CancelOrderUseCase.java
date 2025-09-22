package com.example.hexcrud.domain.port.in.order;

import com.example.hexcrud.domain.model.order.Order;

public interface CancelOrderUseCase {
    /**
     * Cancela um pedido, mudando seu estado para CANCELLED.
     * @param orderId O ID do pedido a ser cancelado.
     * @return O pedido atualizado.
     * @throws IllegalStateException se o pedido já estiver cancelado.
     */
    Order execute(String orderId);
}