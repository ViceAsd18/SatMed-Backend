package com.satmed.atencion_medica.models.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atenciones_medicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Modelo que representa una atención médica dentro de la clínica SAT-MED")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la atención médica", example = "1")
    private Integer id;

    @Schema(description = "RUT o Identificación del paciente", example = "12345678-9")
    private String pacienteRut;

    @Schema(description = "Nombre del médico asignado", example = "Dr. Carlos Mendoza")
    private String medicoNombre;

    @Schema(description = "Diagnóstico médico preliminar", example = "Hipertensión arterial en control")
    private String diagnostico;

    @Schema(description = "Fecha y hora del registro de la atención", example = "2026-06-27T10:30:00")
    private String fechaAtencion;
}