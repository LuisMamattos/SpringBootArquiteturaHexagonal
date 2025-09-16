package com.example.hexcrud.domain.model;

public class Cliente {
    
    private String id;
    private String nome;
    private String email;

    public Cliente() {}
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
