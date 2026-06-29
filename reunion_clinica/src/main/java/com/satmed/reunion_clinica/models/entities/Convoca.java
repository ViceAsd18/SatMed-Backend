package com.satmed.reunion_clinica.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "convoca")
public class Convoca {

    @EmbeddedId
    private ConvocaId id;

    @ManyToOne
    @MapsId("idReunion")
    @JoinColumn(name = "id_reunion")
    private ReunionClinica reunionClinica;
}
