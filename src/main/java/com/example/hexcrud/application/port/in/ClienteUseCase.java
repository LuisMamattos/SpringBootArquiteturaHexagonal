package com.example.hexcrud.application.port.in;

import java.util.List;

import com.example.hexcrud.domain.Cliente;

public interface ClienteUseCase {
    Cliente cadastrar(Cliente cliente);
    List<Cliente> listar();
    Cliente buscarPorId(Long id);
    void remover(Long id);
}
