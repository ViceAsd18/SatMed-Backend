package com.satmed.profesional.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PROFESIONAL")
public class Profesional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesional;

    @Column(nullable = false, unique = true)
    private String numeroRegistroProfesional;

    @Column(name = "id_usuario", nullable = false, unique = true)
    private Integer idUsuario;


    @Column(name = "id_especialidad", nullable = false)
    private Integer idEspecialidad;

}
