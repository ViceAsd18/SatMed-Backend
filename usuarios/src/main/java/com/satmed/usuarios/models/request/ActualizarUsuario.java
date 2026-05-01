package com.satmed.usuarios.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActualizarUsuario {
    
    @NotBlank(message = "El primer nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String pnombreUsuario;


    private String snombreUsuario;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apaternoUsuario;

    @NotBlank(message = "El apellido materno es obligatorio")
    private String amaternoUsuario;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ingresar un formato de correo válido")
    private String emailUsuario;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^\\+?[0-9]{9,15}$", message = "Formato de teléfono inválido")
    private String telefonoUsuario;


    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasenaUsuario;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimientoUsuario;

    @NotNull(message = "El género es obligatorio")
    private Integer idGenero;

    @NotNull(message = "El rol es obligatorio")
    private Integer idRol;

    //Datos de la dirección para actualizar
    @NotBlank(message = "La calle es obligatoria")
    private String calleDireccion;

    @NotNull(message = "El número de dirección es obligatorio")
    @Min(value = 1, message = "El número debe ser mayor a 0")
    private Integer numeroDireccion;

    @NotNull(message = "La comuna es obligatoria")
    private Integer idComuna;

}
