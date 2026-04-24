package com.satmed.publicacion.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarPublicacion{

    @NotNull(message = "El ID de la publicación es necesario para actualizar")
    private Long idPublicacion;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String contenido;

    @NotNull(message = "Debe especificar si la publicación sigue activa")
    private Boolean activoPublicacion;
}
