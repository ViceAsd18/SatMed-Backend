package com.satmed.fichaClinica.models.request;

import lombok.Data;

@Data
public class ActualizarFichaClinica {
    
    private String observaciones;
    private Boolean activa;

}
