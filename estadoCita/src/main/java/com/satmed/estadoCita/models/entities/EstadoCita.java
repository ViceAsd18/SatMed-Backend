package com.satmed.estadoCita.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ESTADO_CITA")
public class EstadoCita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoCita;

    @Column(nullable = false, length = 100)
    private String nombreEstadoCita;
}
