package com.satmed.profesional.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.profesional.model.entities.Profesional;
import com.satmed.profesional.model.request.ActualizarProfesional;
import com.satmed.profesional.model.request.AgregarProfesional;
import com.satmed.profesional.services.ProfesionalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/profesionales")
@CrossOrigin
@RequiredArgsConstructor
public class ProfesionalController {

	private final ProfesionalService profesionalService;

	@GetMapping
	public ResponseEntity<List<Profesional>> listar() {
		return ResponseEntity.ok(profesionalService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Profesional> obtener(@PathVariable Integer id) {
		return profesionalService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Profesional> agregar(@Valid @RequestBody AgregarProfesional body) {
		Profesional creado = profesionalService.agregar(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Profesional> actualizar(
			@PathVariable Integer id,
			@Valid @RequestBody ActualizarProfesional body) {
		return profesionalService.actualizar(id, body)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * @param fisico si es true elimina el registro de la BD; si es false (por defecto) desactiva (activoProfesional = false).
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(
			@PathVariable Integer id,
			@RequestParam(name = "fisico", defaultValue = "false") boolean fisico) {
		boolean ok = profesionalService.eliminar(id, fisico);
		if (!ok) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
