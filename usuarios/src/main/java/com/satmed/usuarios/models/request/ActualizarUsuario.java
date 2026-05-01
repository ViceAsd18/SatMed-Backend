package com.satmed.usuarios.models.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ActualizarUsuario {
    
    private String pnombreUsuario;
    private String snombreUsuario;
    private String apaternoUsuario;
    private String amaternoUsuario;
    private String emailUsuario;
    private String telefonoUsuario;
    private LocalDate fechaNacimientoUsuario;
    private Integer idGenero;
    private Integer idRol;

    //Datos de la dirección para actualizar
    private String calleDireccion;
    private Integer numeroDireccion;
    private Integer idComuna;

}
