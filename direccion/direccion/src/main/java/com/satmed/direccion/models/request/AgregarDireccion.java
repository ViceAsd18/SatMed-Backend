package com.satmed.direccion.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarDireccion {

    @NotBlank(message = "La calle es obligatoria")
    private String calleDireccion;

    @NotNull(message = "El numero es obligatorio")
    private Integer numeroDireccion;

    @NotNull(message = "El id de comuna es obligatorio")
    private Integer idComuna;
}
