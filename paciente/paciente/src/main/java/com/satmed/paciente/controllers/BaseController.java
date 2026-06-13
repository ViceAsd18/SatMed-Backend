package com.satmed.paciente.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.satmed.paciente.models.dto.VersionInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Base", description = "Controlador raíz para verificar el estado del microservicio")
public class BaseController {
    
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("")
    @Operation(summary = "Obtener información de versión del microservicio")
    public VersionInfo base() {
        return new VersionInfo(appName, appVersion);
    }
}
