package com.satmed.reunion_clinica.models.request;

import lombok.Data;
import java.util.List;

@Data
public class ReunionRequest {
    private String fechaRealizada;
    private String descripcionReunion;
    private List<Long> idProfesionalesInvitados;
}