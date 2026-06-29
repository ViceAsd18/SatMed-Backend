package com.satmed.atencion_medica.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrarBitacoraRequest {
 
    @NotBlank(message = "La descripción del evento es obligatoria")
    private String descripcion;

    @NotNull(message = "El ID del tipo de evento es obligatorio")
    private Long idTipoEvento;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long idUsuario;

    @NotNull(message = "El ID de la atención médica es obligatorio")
    private Long idAtencion;

}
