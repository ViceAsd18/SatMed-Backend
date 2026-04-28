package com.satmed.usuarios.models.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(nullable = false, unique = true, length = 12)
    private String rutUsuario;

    @Column(nullable = false, length = 50)
    private String pnombreUsuario;

    @Column(length = 50)
    private String snombreUsuario;

    @Column(nullable = false, length = 50)
    private String apaternoUsuario;

    @Column(nullable = false, length = 50)
    private String amaternoUsuario;

    @Column(nullable = false, unique = true, length = 150)
    private String emailUsuario;

    @Column(length = 12)
    private String telefonoUsuario;

    @Column(nullable = false)
    private LocalDate fechaNacimientoUsuario;

    @Column(nullable = false, length = 100)
    private String contrasenaUsuario;

    @Column(nullable = false)
    private Boolean activo; 

    @Column(updatable = false)
    private LocalDate fechaCreacionUsuario;

    @Column(nullable = false)
    private Integer idGenero;

    @Column(nullable = false)
    private Integer idDireccion;

    @Column(nullable = false)
    private Integer idRol;

}