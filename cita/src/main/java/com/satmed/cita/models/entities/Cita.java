package com.satmed.cita.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data // Esto reemplaza a @Getter y @Setter y agrega más funciones útiles
@Table(name = "CITA")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, length = 250)
    private String motivoCita;

    @Column(nullable = false)
    private Integer estadoCitaIdEstadoCita;

    @Column(nullable = false)
    private Integer profesionalIdProfesional;

    @Column(nullable = false)
    private Integer pacienteIdPaciente;
}
