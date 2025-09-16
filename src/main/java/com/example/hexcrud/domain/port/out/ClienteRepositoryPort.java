package com.example.hexcrud.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Cliente;

public interface ClienteRepositoryPort {
    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorId(String id);
    List<Cliente> buscarTodos();
    void deletar(String id);
    Cliente atualizarCliente(String id, Cliente clienteAtualizado);
    
}
