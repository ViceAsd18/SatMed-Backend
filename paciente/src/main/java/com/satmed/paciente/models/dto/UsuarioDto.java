package com.satmed.paciente.models.dto;

public record UsuarioDto(
    Integer idUsuario,
    String rutUsuario,

    String pnombreUsuario,
    String snombreUsuario,
    String apaternoUsuario,
    String amaternoUsuario,

    String contrasenaUsuario,
    String emailUsuario,
    String telefonoUsuario,

    String fechaCreacionUsuario,
    String fechaNacimientoUsuario,

    Boolean activo,

    Integer idDireccion,
    Integer idGenero,
    Integer idRol

) {}
