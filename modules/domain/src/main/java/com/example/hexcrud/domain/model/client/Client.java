package com.example.hexcrud.domain.model.client;

public class Client {

    private String id;
    private String name;
    private String email;

    public Client() {}
    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void updateDetails(String newName, String newEmail) {
        this.name = newName;
        this.email = newEmail;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

   
    public void setId(String id) { this.id = id; }
}