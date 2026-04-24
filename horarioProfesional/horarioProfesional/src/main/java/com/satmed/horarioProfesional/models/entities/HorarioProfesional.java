package com.satmed.horarioProfesional.models.entities;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HORARIOPROFESIONAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorarioProfesional;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;
}
