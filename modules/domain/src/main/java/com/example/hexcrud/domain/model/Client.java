package com.example.hexcrud.domain.model;

public class Client {
    
    private String id;
    private String name;
    private String email;

    public Client() {}
    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
