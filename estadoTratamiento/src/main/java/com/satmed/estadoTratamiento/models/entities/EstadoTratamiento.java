package com.satmed.estadoTratamiento.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ESTADO_TRATAMIENTO")
public class EstadoTratamiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoTratamiento;

    @Column(nullable = false, length = 50)
    private String nombreEstadoTratamiento;

}
