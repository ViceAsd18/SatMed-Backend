package com.satmed.atencion_medica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "INTERCONSULTA")
public class Interconsulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interconsulta")
    private Long idInterconsulta;

    @Column(name = "motivo", nullable = false, length = 150)
    private String motivo;

    @Column(name = "fecha_emision", nullable = false)
    private String fechaEmision;

    @ManyToOne
    @JoinColumn(name = "id_atencion", nullable = false)
    private AtencionMedica atencionMedica;

    @Column(name = "id_profesional", nullable = false)
    private Long idProfesional;

}
