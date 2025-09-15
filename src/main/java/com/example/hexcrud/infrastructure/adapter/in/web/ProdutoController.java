package com.example.hexcrud.infrastructure.adapter.in.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexcrud.application.port.in.ProdutoUseCase;
import com.example.hexcrud.domain.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoUseCase.cadastrar(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoUseCase.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoUseCase.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        produtoUseCase.remover(id);
    }
}
