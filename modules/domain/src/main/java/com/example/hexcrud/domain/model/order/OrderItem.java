package com.example.hexcrud.domain.model.order;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.hexcrud.domain.model.product.Product;


public class OrderItem {

    private String productId;
    private String productName;
    private int quantity;
    private BigDecimal price; 

    
    private OrderItem(String productId, String productName, int quantity, double price) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
    }

    public static OrderItem create(Product product, int quantity) {
        return new OrderItem(product.getId(), product.getName(), quantity, product.getPrice());
    }

    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
    
   
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public BigDecimal getPrice() { return price; }

    
    private OrderItem() {}
}