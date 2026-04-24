package com.satmed.EnfermedadCronica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ENFERMEDADES_CRONICAS")
public class EnfermedadCronica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnfermedadCronica;

    @Column(nullable = false, length = 100)
    private String nombreEnfermedadCronica;

}
