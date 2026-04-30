package com.satmed.usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient generoWebClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:7120")
                .build();
    }

    @Bean
    public WebClient rolWebClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:6500")
                .build();
    }

    @Bean
    public WebClient direccionWebClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

}
