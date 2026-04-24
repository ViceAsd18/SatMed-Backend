package com.satmed.profesional.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgregarProfesional {

	@NotBlank(message = "El número de registro profesional es obligatorio")
	private String numeroRegistroProfesional;

	@NotNull(message = "El estado activo es obligatorio")
	private Boolean activoProfesional;
}
