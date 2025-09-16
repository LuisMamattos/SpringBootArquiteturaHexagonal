package com.example.hexcrud.domain.port.in;

import java.util.List;
import java.util.Optional;

import com.example.hexcrud.domain.model.Cliente;

public interface ClienteUseCase {
    Cliente criarCliente(Cliente cliente);
    Optional<Cliente> buscarCliente(String id);
    List<Cliente> listarClientes();
    void deletarCliente(String id);
    Cliente atualizarCliente(String id, Cliente clienteAtualizado);
}
