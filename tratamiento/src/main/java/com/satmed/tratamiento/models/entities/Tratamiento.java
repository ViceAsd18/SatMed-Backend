package com.satmed.tratamiento.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRATAMIENTOS")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTratamiento;

    @Column(nullable = false, length = 500)
    private String descripcionTratamiento;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Column(nullable = false)
    private Integer idAtencionMedica;

    private Integer idEstadoTratamiento;

}

