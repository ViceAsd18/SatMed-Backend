package com.satmed.reunion_clinica.config;


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
            .title("Gestion de reuniones clinicas")
            .description("Agregar - Actualizar - Eliminar - Editar reuniones clinicas")
            .version(appName)
            .contact(new Contact()
                .name("Vicente Ramírez - Lisett Granadillo")
                .email("vicen.ramirezg@duocuc.cl - li.granadillo@duocuc.cl"))
        );
    }
    

}
