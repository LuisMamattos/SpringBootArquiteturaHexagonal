package com.example.hexcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.hexcrud")
public class HexcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexcrudApplication.class, args);
    }
}