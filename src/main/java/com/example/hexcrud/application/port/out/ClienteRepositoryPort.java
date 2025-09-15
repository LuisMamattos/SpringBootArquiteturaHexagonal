
package com.example.hexcrud.application.port.out;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.Cliente;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    void deleteById(Long id);
}
