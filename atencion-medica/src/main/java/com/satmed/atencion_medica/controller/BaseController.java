package com.satmed.atencion_medica.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
=======
>>>>>>> desarrollo
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.atencion_medica.models.dto.VersionInfo;
<<<<<<< HEAD
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
@Tag(name = "Base", description = "Controlador raíz para verificar el estado y versión del microservicio")
public class BaseController {
    
    @Value("${app.name:atencion-medica}")
    private String appName;

    @Value("${app.version:0.0.1-SNAPSHOT}")
    private String appVersion;

    @GetMapping("")
    @Operation(summary = "Obtener información de la versión", description = "Retorna el nombre del microservicio junto con su versión actual configurada.")
    public VersionInfo base() {
        return new VersionInfo(appName, appVersion);
    }
}
=======

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


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
