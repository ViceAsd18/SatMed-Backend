package com.satmed.fichaClinica.models.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "FICHAS_CLINICA")
public class FichaClinica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFichaClinica;

    @Column(nullable = false, unique = true)
    private Integer idPaciente;

    @Column(length = 500)
    private String observaciones;

    @Column(nullable = false)
    private Boolean activa;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

}
