package com.satmed.paciente.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgregarPaciente {

    @NotNull(message = "El idPaciente es obligatorio")
    private Integer idPaciente;

    @NotNull(message = "El idEstadoPaciente es obligatorio")
    private Integer idEstadoPaciente;
}
