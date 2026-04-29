package com.satmed.usuarios.models.request;

import lombok.Data;

@Data
public class AgregarUsuario {
    
    private String rutUsuario;
    private String pnombreUsuario;
    private String snombreUsuario;
    private String apaternoUsuario;
    private String amaternoUsuario;
    private String emailUsuario;
    private String telefonoUsuario;
    private String fechaNacimientoUsuario; 
    private String contrasenaUsuario;
    private Integer idGenero;
    private Integer idDireccion;
    private Integer idRol;

}
