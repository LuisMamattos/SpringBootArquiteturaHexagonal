package com.example.hexcrud.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String id;
    private Client client;
    private List<Product> products;
    private double totalPrice;
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(Client client, List<Product> products) {
        this.client = client;
        this.products = products;
        this.totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
        this.orderDate = LocalDateTime.now();
    }
    
    // getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
}