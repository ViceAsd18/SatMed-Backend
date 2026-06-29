package com.satmed.reunion_clinica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reunion_clinica")
public class ReunionClinica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reunion")
    private Long idReunion;

    @Column(name = "fecha_realizada", nullable = false)
    private String fechaRealizada;

    @Column(name = "descripcion_reunion", nullable = false, length = 500)
    private String descripcionReunion;

}
