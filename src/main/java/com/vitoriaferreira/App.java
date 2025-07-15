package com.vitoriaferreira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vitoriaferreira.config.ConfigManager;

@SpringBootApplication // inicializa spring
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        // conexao com API externa usando ConfigManager
        // define a URL da API externa no objeto ConfigManager
        ConfigManager.getInstance().setConfig("deviceApiUrl", "https://dummyjson.com/products/category/smartphones");

    }
}