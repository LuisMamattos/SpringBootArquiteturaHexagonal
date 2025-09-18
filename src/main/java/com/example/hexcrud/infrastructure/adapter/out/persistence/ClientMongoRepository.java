package com.example.hexcrud.infrastructure.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexcrud.domain.model.Client;

import java.util.Optional;

public interface ClientMongoRepository extends MongoRepository<Client, String> {
      Optional<Client> findByEmail(String email);
}
