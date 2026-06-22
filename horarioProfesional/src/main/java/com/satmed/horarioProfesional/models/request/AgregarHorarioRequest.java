package com.satmed.horarioProfesional.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarHorarioRequest {

    @NotBlank(message = "La hora de inicio es obligatoria")
    private String horaInicio;

    @NotBlank(message = "La hora de fin es obligatoria")
    private String horaFin;

    @NotNull(message = "El ID del profesional es obligatorio")
    private Long idProfesional;

    @NotNull(message = "El ID del día de la semana es obligatorio")
    private Long idDiaSemana;

}
