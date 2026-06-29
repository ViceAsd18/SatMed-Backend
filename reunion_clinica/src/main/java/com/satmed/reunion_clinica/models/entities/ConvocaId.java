package com.satmed.reunion_clinica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class ConvocaId implements Serializable {

    @Column(name = "id_profesional")
    private Long idProfesional;

    @Column(name = "id_reunion")
    private Long idReunion;
}