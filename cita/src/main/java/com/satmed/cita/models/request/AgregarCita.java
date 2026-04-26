package com.satmed.cita.models.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Esto reemplaza a @Getter y @Setter y agrega más funciones útiles
@Builder // Permite crear objetos de forma fácil
@AllArgsConstructor // Crea un constructor con todos los campos
@NoArgsConstructor // Crea un constructor vacío (obligatorio para Spring)
public class AgregarCita {

    @NotNull(message = "La fecha y hora de la cita es obligatoria")
    @Future(message = "La fecha y hora debe ser futura")
    private LocalDateTime fechaHora;

    @NotBlank(message = "El motivo de la cita es obligatorio")
    @Size(max = 250, message = "El motivo no puede superar los 250 caracteres")
    private String motivoCita;

    @NotNull(message = "El estado de cita es obligatorio")
    private Integer estadoCitaIdEstadoCita;

    @NotNull(message = "El profesional es obligatorio")
    private Integer profesionalIdProfesional;

    @NotNull(message = "El paciente es obligatorio")
    private Integer pacienteIdPaciente;
}
