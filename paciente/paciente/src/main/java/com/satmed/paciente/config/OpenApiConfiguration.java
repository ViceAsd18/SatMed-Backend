package com.satmed.paciente.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
    
    @Value("${app.version}")
    private String appVersion;

    @Bean
    public OpenAPI documentacionOpenApi(){
        return new OpenAPI()
            .info(new Info()
            .title("Catálogo de Pacientes API")
            .description("Consultar y gestionar pacientes a utilizar en SAT-MED")
            .version(appVersion)
            .contact(new Contact()
                .name("Vicente Ramírez - Lisett Granadillo")
                .email("vicen.ramirezg@duocuc.cl - li.granadillo@duocuc.cl")
            )
        );
    }
}