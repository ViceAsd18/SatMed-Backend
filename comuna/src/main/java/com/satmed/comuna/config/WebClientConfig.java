package com.satmed.comuna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient regionWebClient(){
        return WebClient.builder()
                .baseUrl("https://localhost:6200/")
                .build();
    }

}


