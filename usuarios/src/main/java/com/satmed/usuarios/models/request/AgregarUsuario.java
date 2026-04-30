package com.satmed.usuarios.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AgregarUsuario {
    
    @NotBlank(message = "El RUT es obligatorio")
    @Size(min = 8, max = 12, message = "El RUT debe tener entre 8 y 12 caracteres")
    private String rutUsuario;

    @NotBlank(message = "El primer nombre es obligatorio")
    private String pnombreUsuario;

    private String snombreUsuario;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apaternoUsuario;

    @NotBlank(message = "El apellido materno es obligatorio")
    private String amaternoUsuario;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ingresar un formato de email válido")
    private String emailUsuario;

    private String telefonoUsuario;

    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimientoUsuario; 

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasenaUsuario;

    @NotNull(message = "El género es obligatorio")
    private Integer idGenero;
    
    @NotNull(message = "El rol es obligatorio")
    private Integer idRol;

    //Campos para la direccion cuando un usuario se registra, se crean una direccion nueva y se asigna al usuario
    private String calleDireccion;
    private Integer numeroDireccion;
    private Integer idComuna;

}
