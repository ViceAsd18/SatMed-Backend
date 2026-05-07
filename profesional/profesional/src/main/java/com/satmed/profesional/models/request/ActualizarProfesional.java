package com.satmed.profesional.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarProfesional {

    @NotBlank(message = "El id profesional es obligatorio")
    private Integer idProfesional;

    @NotNull(message = "El ID de la especialidad es obligatorio")
    private Integer idEspecialidad;


}
