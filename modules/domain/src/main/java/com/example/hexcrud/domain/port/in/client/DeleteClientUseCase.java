package com.example.hexcrud.domain.port.in.client;

public interface DeleteClientUseCase {
    
    record Input(String id) {}

    sealed interface Output {
        record Deleted() implements Output {}
        record NotFound(String id) implements Output {}
    }

    Output execute(Input input);
}
