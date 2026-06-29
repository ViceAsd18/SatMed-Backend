package com.satmed.alergias.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.alergias.models.dto.VersionInfo;
<<<<<<< HEAD
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
@Tag(name = "Base", description = "Controlador base para verificar la información del microservicio de Alergias")
public class BaseController {
    
    @Value("${app.name:Microservicio Alergias}")
    private String appName;

    @Value("${app.version:0.0.1-SNAPSHOT}")
    private String appVersion;

    @GetMapping("")
    @Operation(summary = "Obtener información de la versión", description = "Retorna el nombre y la versión actual del microservicio")
    public VersionInfo base() {
        return new VersionInfo(appName, appVersion);
    }
}
=======

@RestController
@RequestMapping("/")
public class BaseController {
    
    @Value("${app.name}")
    private String nombre;

    @Value("${app.version}")
    private String version;

    @GetMapping("")
    public VersionInfo base() {
        return new VersionInfo(nombre, version);
    }
    

}   
>>>>>>> desarrollo
