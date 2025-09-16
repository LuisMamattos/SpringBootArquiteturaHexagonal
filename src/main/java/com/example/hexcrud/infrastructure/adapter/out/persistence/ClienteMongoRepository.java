package com.example.hexcrud.infrastructure.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexcrud.domain.model.Cliente;

public interface ClienteMongoRepository extends MongoRepository<Cliente, String> {}
