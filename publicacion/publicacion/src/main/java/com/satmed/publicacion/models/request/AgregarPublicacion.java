package com.satmed.publicacion.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarPublicacion {

    @NotBlank(message = "El título es requerido")
    private String titulo;

    @NotBlank(message = "El contenido es requerido")
    private String contenido;

    @NotNull(message = "El estado activo es requerido")
    private Boolean activoPublicacion;
}