package com.satmed.horarioProfesional.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HORARIO_PROFESIONAL")
public class HorarioProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario_profesional")
    private Long idHorarioProfesional;

    @Column(name = "hora_inicio", nullable = false)
    private String horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private String horaFin;

    @Column(name = "PROFESIONAL_id_profesional", nullable = false)
    private Long idProfesional;

    @ManyToOne  
    @JoinColumn(name = "DIA_SEMANA_id_dia_semana", nullable = false)
    private DiaSemana diaSemana;

}
