package com.satmed.tratamiento.models.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AgregarTratamiento {
    
    private String descripcionTratamiento;
    private LocalDate fechaFin;
    private Integer idAtencionMedica;

}
