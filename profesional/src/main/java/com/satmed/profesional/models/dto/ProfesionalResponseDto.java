package com.satmed.profesional.models.dto;


public record ProfesionalResponseDto(
    Integer idProfesional,
    String numeroRegistroProfesional,
    UsuarioDto usuario,
    EspecialidadDto especialidad
) {}