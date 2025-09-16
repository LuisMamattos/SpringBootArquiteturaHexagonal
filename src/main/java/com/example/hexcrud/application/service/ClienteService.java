package com.example.hexcrud.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hexcrud.domain.model.Cliente;
import com.example.hexcrud.domain.port.in.ClienteUseCase;
import com.example.hexcrud.domain.port.out.ClienteRepositoryPort;

@Service
public class ClienteService implements ClienteUseCase {

    private final ClienteRepositoryPort repository;

    public ClienteService(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return repository.salvar(cliente);
    }

    @Override
    public Optional<Cliente> buscarCliente(String id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return repository.buscarTodos();
    }

    @Override
    public void deletarCliente(String id) {
        repository.deletar(id);
    }
    public Cliente atualizarCliente(String id, Cliente clienteAtualizado) {
        
        return repository.atualizarCliente(id, clienteAtualizado);
    }
    
}
