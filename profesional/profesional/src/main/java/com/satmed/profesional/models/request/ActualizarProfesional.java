package com.satmed.profesional.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarProfesional {

    @NotNull(message = "El ID de la especialidad es obligatorio")
    private Integer idEspecialidad;


}
