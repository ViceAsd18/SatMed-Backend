package com.satmed.paciente.models.dto;

public record PacienteResponseDto(
    Integer idPaciente,
    UsuarioDto usuario
) {}