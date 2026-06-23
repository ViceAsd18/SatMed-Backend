package com.satmed.atencion_medica.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrarInterconsultaRequest {
    
    @NotBlank(message = "El motivo de la interconsulta es obligatorio")
    private String motivo;

    @NotBlank(message = "La fecha de emisión es obligatoria")
    private String fechaEmision;

    @NotNull(message = "El ID de la atención médica es obligatorio")
    private Long idAtencion;

    @NotNull(message = "El ID del profesional especialista es obligatorio")
    private Long idProfesional;

}
