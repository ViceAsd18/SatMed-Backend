package com.satmed.profesional.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.profesional.models.entities.Profesional;
import com.satmed.profesional.models.request.ActualizarProfesional;
import com.satmed.profesional.models.request.AgregarProfesional;
import com.satmed.profesional.services.ProfesionalService;



@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

	@Autowired
	private ProfesionalService profesionalService;

	@GetMapping("")
	public List<Profesional> obtenerTodosLosProfesionales() {
		return profesionalService.obtenerTodosLosProfesionales();
	}

	@GetMapping("/{idProfesional}")
	public Profesional obtenerProfesionalPorId(@PathVariable Integer idProfesional) {
		return profesionalService.obtenerProfesionalPorId(idProfesional);
	}

	@PostMapping("")
	public Profesional agregarProfesional(@RequestBody AgregarProfesional request) {
		return profesionalService.agregarProfesional(request);
	}

	@PutMapping("")
	public Profesional actualizarProfesional(@RequestBody ActualizarProfesional request){
		return profesionalService.actualizarProfesional(request);
	}

	@DeleteMapping("/{idProfesional}")
	public String eliminarProfesional(@PathVariable Integer idProfesional) {
		return profesionalService.eliminarProfesional(idProfesional);
	}




}
