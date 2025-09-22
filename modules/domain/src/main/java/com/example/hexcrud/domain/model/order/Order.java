package com.example.hexcrud.domain.model.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.product.Product;


public class Order {

    private String id;
    private String clientId;
    private List<OrderItem> items = new ArrayList<>();
    private BigDecimal totalPrice;
    private OrderStatus status;
    private LocalDateTime orderDate;

    private Order(String clientId) {
        this.clientId = clientId;
        this.status = OrderStatus.PENDING;
        this.orderDate = LocalDateTime.now();
        calculateTotal();
    }

    public static Order create(String clientId) {
        if (clientId == null || clientId.isBlank()) {
            throw new IllegalArgumentException("Client ID cannot be null or empty.");
        }
        return new Order(clientId);
    }


    public void addItem(Product product, int quantity) {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Cannot add items to an order that is not in PENDING state.");
        }
        
        Optional<OrderItem> existingItem = findItemByProductId(product.getId());
        if (existingItem.isPresent()) {
            throw new IllegalArgumentException("Product already exists in the order. Use update quantity instead.");
        }

        OrderItem newItem = OrderItem.create(product, quantity);
        this.items.add(newItem);
        calculateTotal();
    }

    public void removeItem(String productId) {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Cannot remove items from an order that is not in PENDING state.");
        }
        items.removeIf(item -> item.getProductId().equals(productId));
        calculateTotal();
    }
    
    public void confirm() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Only PENDING orders can be confirmed.");
        }
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot confirm an empty order.");
        }
        this.status = OrderStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Order is already cancelled.");
        }
        this.status = OrderStatus.CANCELLED;
    }

    private void calculateTotal() {
        this.totalPrice = items.stream()
                               .map(OrderItem::getTotal)
                               .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Optional<OrderItem> findItemByProductId(String productId) {
        return items.stream().filter(item -> item.getProductId().equals(productId)).findFirst();
    }
    
    public String getId() { return id; }
    public String getClientId() { return clientId; }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setId(String id) { this.id = id; }
    
    private Order() {}
}