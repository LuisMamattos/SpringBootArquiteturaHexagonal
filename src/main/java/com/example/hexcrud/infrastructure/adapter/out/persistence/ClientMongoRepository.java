package com.example.hexcrud.infrastructure.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexcrud.domain.model.Client;

public interface ClientMongoRepository extends MongoRepository<Client, String> {}
