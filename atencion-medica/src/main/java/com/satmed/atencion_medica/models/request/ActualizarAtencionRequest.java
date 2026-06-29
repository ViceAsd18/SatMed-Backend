package com.satmed.atencion_medica.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarAtencionRequest {

    @NotNull(message = "El ID de la atención a modificar es obligatorio")
    private Long idAtencion;

    @NotBlank(message = "La fecha de atención es obligatoria")
    private String fechaAtencion;

    @NotBlank(message = "El motivo es obligatorio")
    private String motivo;

    @NotBlank(message = "El diagnóstico es obligatorio")
    private String diagnostico;

    @NotBlank(message = "Las indicaciones son obligatorias")
    private String indicaciones;
}