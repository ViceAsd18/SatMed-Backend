package com.satmed.horarioProfesional.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DIA_SEMANA")
public class DiaSemana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dia_semana")
    private Long idDiaSemana;

    @Column(name = "nombre_dia_semana", nullable = false, length = 25)
    private String nombreDiaSemana;
}