package com.satmed.especialidad.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenApiConfiguration {
    
    @Value("${app.version}")
    private String appVersion;

    @Bean
    public OpenAPI documentacionOpenApi(){
        return new OpenAPI()
            .info(new Info()
            .title("Catalogo de especialidades API")
            .description("Consultar - Agregar - Editar - Eliminar especialidades a utilizar en SAT-MED")
            .version(appVersion)
            .contact(new Contact()
                .name("Vicente Ramírez - Lisett Granadillo")
                .email("vicen.ramirezg@duocuc.cl - li.granadillo@duocuc.cl")
            )
        );
    }

}
