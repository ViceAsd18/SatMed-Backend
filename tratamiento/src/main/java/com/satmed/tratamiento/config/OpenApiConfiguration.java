package com.satmed.tratamiento.config;

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
            .title("Gestion de tratamientos")
            .description("Agregar - Actualizar - Eliminar - Editar tratamientos")
            .version(appName)
            .contact(new Contact()
                .name("Vicente Ramírez - lisett granadillo")
                .email("vicen.ramirezg@duocuc.cl - lisett.granadillo@duocuc.cl"))
        );
    }
    

}
