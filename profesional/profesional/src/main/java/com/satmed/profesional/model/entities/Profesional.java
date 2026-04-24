package com.satmed.profesional.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROFESIONAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProfesional")
	private Integer idProfesional;

	@Column(name = "numeroRegistroProfesional", nullable = false, length = 100)
	private String numeroRegistroProfesional;

	@Column(name = "activoProfesional", nullable = false)
	private Boolean activoProfesional;
}
