package com.satmed.atencion_medica.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarInterconsultaRequest {
    
    @NotNull(message = "El ID de la interconsulta es obligatorio")
    private Long idInterconsulta;

    @NotBlank(message = "El motivo de la interconsulta es obligatorio")
    private String motivo;

    @NotBlank(message = "La fecha de emisión es obligatoria")
    private String fechaEmision;

}
