package com.satmed.comuna.models.request;

import lombok.Data;

@Data
public class ActualizarComuna {
    
    private Integer idComuna;
    private String nombreComuna;
    private Integer idRegion;

}
