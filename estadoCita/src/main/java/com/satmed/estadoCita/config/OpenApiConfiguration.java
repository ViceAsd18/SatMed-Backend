package com.satmed.estadoCita.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
    
    @Value("${app.name}")
    private String appName;

    @Bean
    public OpenAPI documentacionOpenApi(){
        return new OpenAPI()
            .info(new Info()
            .title("Gestion de estados de citas")
            .description("Consulta estados de citas")
            .version(appName)
            .contact(new Contact()
                .name("Vicente Ramírez - lisett granadillo")
                .email("vicen.ramirezg@duocuc.cl - li.granadillo@duocuc.cl"))
        );
    }
    

}

