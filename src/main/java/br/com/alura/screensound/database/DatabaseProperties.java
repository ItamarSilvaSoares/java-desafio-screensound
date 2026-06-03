package br.com.alura.screensound.database;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.database")
public record DatabaseProperties(
    String host, Integer port, String name, String username, String password) {}
