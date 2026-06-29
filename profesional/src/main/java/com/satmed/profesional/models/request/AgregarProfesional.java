package com.satmed.profesional.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AgregarProfesional {

	@NotNull(message = "El ID de usuario es obligatorio")
    private Integer idUsuario;

    @NotBlank(message = "El número de registro médico es obligatorio")
    @Size(min = 4, max = 50, message = "El registro debe tener entre 4 y 50 caracteres")
    private String numeroRegistroProfesional;

    @NotNull(message = "La especialidad es obligatoria")
    private Integer idEspecialidad;
}
