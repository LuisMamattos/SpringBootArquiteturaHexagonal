package com.example.hexcrud.domain.model.product;

public class Product {

    private String id;
    private String name;
    private double price;

    public Product() {}
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void updateDetails(String newName, double newPrice) {
        this.name = newName;
        this.price = newPrice;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setId(String id) { this.id = id; }
}