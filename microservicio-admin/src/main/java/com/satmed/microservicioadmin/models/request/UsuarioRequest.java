package com.satmed.microservicioadmin.models.request;

import lombok.Data;

@Data
public class UsuarioRequest {

    private Long idUsuario;
    private String rut;
    private String pnombreUsu;
    private String snombreUsu;
    private String apaternoUsu;
    private String amaternoUsu;
    private String emailUsuario;
    private String telefono;
    private String fechaNacimiento;
    private String contrasena;
    private String activo;
    private String fechaRegistro;
    private Long generoIdGenero;
    private Long direccionIdDireccion;
    private Long pacienteIdPaciente;
    private Long rolRolId;
}
