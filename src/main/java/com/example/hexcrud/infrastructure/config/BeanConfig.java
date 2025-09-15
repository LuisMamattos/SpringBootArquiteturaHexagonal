package com.example.hexcrud.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hexcrud.application.port.in.ClienteUseCase;
import com.example.hexcrud.application.port.in.ProdutoUseCase;
import com.example.hexcrud.application.port.out.ClienteRepositoryPort;
import com.example.hexcrud.application.port.out.ProdutoRepositoryPort;
import com.example.hexcrud.application.service.ClienteService;
import com.example.hexcrud.application.service.ProdutoService;

@Configuration
public class BeanConfig {
    @Bean
    ClienteUseCase clienteUseCase(ClienteRepositoryPort repository) {
        return new ClienteService(repository);
    }

    @Bean
    ProdutoUseCase produtoUseCase(ProdutoRepositoryPort repository) {
        return new ProdutoService(repository);
    }
}
