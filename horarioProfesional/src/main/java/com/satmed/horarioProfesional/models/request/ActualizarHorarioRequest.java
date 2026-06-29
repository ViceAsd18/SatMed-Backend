package com.satmed.horarioProfesional.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarHorarioRequest {
    
    @NotNull(message = "El ID del horario a actualizar es obligatorio")
    private Long idHorarioProfesional;

    @NotBlank(message = "La hora de inicio es obligatoria")
    private String horaInicio;

    @NotBlank(message = "La hora de fin es obligatoria")
    private String horaFin;

    @NotNull(message = "El ID del día de la semana es obligatorio")
    private Long idDiaSemana;
}
