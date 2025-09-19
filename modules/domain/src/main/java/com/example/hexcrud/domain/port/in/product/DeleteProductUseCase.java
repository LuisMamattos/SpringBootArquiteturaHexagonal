package com.example.hexcrud.domain.port.in.product;

public interface DeleteProductUseCase {
    record Input(String id) {}

    sealed interface Output {
        record Deleted() implements Output {}
        record NotFound(String id) implements Output {}
    }

    Output execute(Input input);
}