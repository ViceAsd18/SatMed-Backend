package com.satmed.microservicioadmin.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "rut")
    private String rut;

    @Column(name = "pnombre_usu")
    private String pnombreUsu;

    @Column(name = "snombre_usu")
    private String snombreUsu;

    @Column(name = "apaterno_usu")
    private String apaternoUsu;

    @Column(name = "amaterno_usu")
    private String amaternoUsu;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "activo")
    private String activo;

    @Column(name = "fecha_registro")
    private String fechaRegistro;

    @Column(name = "genero_id_genero")
    private Long generoIdGenero;

    @Column(name = "direccion_id_direccion")
    private Long direccionIdDireccion;

    @Column(name = "paciente_id_paciente")
    private Long pacienteIdPaciente;

    @Column(name = "rol_rol_id")
    private Long rolRolId;
}
