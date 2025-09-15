package com.example.hexcrud.application.service;

import java.util.List;

import com.example.hexcrud.application.port.in.ClienteUseCase;
import com.example.hexcrud.application.port.out.ClienteRepositoryPort;
import com.example.hexcrud.domain.Cliente;

public class ClienteService implements ClienteUseCase {
    private final ClienteRepositoryPort clienteRepository;

    public ClienteService(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }
}
