package com.satmed.profesional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient usuarioWebClient() {
        return WebClient.builder().baseUrl("http://localhost:7575").build();
    }

    @Bean
    public WebClient especialidadWebClient() {
        return WebClient.builder().baseUrl("http://localhost:7000").build();
    }
}