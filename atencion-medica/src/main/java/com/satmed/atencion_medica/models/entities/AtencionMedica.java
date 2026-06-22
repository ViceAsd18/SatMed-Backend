package com.satmed.atencion_medica.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ATENCION_MEDICA")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Long idAtencion;

    @Column(name = "fecha_atencion", nullable = false)
    private String fechaAtencion;

    @Column(name = "motivo", nullable = false, length = 250)
    private String motivo;

    @Column(name = "diagnostico", nullable = false, length = 250)
    private String diagnostico;

    @Column(name = "indicaciones", nullable = false, length = 250)
    private String indicaciones;

    @Column(name = "id_profesional", nullable = false)
    private Long idProfesional;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;
}