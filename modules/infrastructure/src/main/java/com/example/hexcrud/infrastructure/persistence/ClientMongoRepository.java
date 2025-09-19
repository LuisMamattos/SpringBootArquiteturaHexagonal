package com.example.hexcrud.infrastructure.persistence;

import com.example.hexcrud.domain.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ClientMongoRepository extends MongoRepository<Client, String> {
    Optional<Client> findByEmail(String email);
}