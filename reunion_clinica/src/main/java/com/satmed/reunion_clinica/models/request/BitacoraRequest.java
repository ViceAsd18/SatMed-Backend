package com.satmed.reunion_clinica.models.request;

import lombok.Data;

@Data
public class BitacoraRequest {
    private String descripcion;
    private String fechaEmision;
    private Long idReunion;
    private Long idTipoEvento;
}