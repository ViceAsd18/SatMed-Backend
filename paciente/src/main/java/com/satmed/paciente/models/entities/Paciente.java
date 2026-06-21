package com.satmed.paciente.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PACIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {

    @Id
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "ESTADO_PACIENTE_id_estado_paciente", nullable = false)
    private Integer idEstadoPaciente;
}
