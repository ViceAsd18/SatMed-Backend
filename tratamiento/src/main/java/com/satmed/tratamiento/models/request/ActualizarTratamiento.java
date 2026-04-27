package com.satmed.tratamiento.models.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ActualizarTratamiento {
    
    private String descripcionTratamiento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer idEstadoTratamiento;

}
