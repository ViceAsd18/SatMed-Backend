package com.satmed.usuarios.models.request;

import lombok.Data;

@Data
public class AgregarDireccion {
    private String calleDireccion;
    private Integer numeroDireccion;
    private Integer idComuna;
}
