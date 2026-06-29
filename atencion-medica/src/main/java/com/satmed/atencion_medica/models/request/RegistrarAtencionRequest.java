package com.satmed.atencion_medica.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrarAtencionRequest {
    
    @NotBlank(message = "La fecha de atención es obligatoria")
    private String fechaAtencion;

    @NotBlank(message = "El motivo es obligatorio")
    private String motivo;

    @NotBlank(message = "El diagnóstico es obligatorio")
    private String diagnostico;

    @NotBlank(message = "Las indicaciones son obligatorias")
    private String indicaciones;

    @NotNull(message = "El ID del profesional es obligatorio")
    private Long idProfesional;

    @NotNull(message = "El ID del paciente es obligatorio")
    private Long idPaciente;

}
