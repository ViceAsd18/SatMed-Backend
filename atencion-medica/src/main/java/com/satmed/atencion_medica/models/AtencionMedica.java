package com.satmed.atencion_medica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ATENCIONES_MEDCIAS")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtencionMedica;

    @Column(nullable = false)
    private String fechaAtencion;

    @Column(nullable = false, length=250)
    private String motivo;

    @Column(nullable = false, length=250)
    private String diagnostico;

    @Column(nullable = false, length=250)
    private String indicaciones;

    @Column(nullable = false)
    private Integer idProfesional;

    @Column(nullable = false)
    private Integer idPaciente;

}
