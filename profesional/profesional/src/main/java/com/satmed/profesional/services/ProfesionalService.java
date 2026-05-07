package com.satmed.profesional.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.profesional.models.dto.EspecialidadDto;
import com.satmed.profesional.models.dto.UsuarioDto;
import com.satmed.profesional.models.entities.Profesional;
import com.satmed.profesional.models.request.ActualizarProfesional;
import com.satmed.profesional.models.request.AgregarProfesional;
import com.satmed.profesional.repositories.ProfesionalRepository;


@Service
public class ProfesionalService {

	@Autowired	
	private ProfesionalRepository profesionalRepository;

	@Autowired
	private WebClient usuarioWebClient;

	@Autowired
	private WebClient especialidadWebClient;


	public List<Profesional> obtenerTodosLosProfesionales() {
		return profesionalRepository.findAll();
	}

	public Profesional obtenerProfesionalPorId(Integer idProfesional) {

		Profesional profesionalEncontrado = profesionalRepository.findById(idProfesional).orElse(null);

		if(profesionalEncontrado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesional con ID " + idProfesional + " no encontrado.");
		}

		return profesionalEncontrado;
	}

	public Profesional agregarProfesional(AgregarProfesional request){

		validarUsuarioExiste(request.getIdUsuario());
		validarEspecialidadExiste(request.getIdEspecialidad());

		if(profesionalRepository.existsByIdUsuario(request.getIdUsuario())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario con ID " + request.getIdUsuario() + " ya está registrado como profesional.");
		}

		if (profesionalRepository.existsByNumeroRegistroProfesional(request.getNumeroRegistroProfesional())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El número de registro médico ya existe.");
		}


		Profesional nuevoProfesional = new Profesional();
		nuevoProfesional.setIdUsuario(request.getIdUsuario());
		nuevoProfesional.setNumeroRegistroProfesional(request.getNumeroRegistroProfesional());

		nuevoProfesional.setIdEspecialidad(request.getIdEspecialidad());	

		return profesionalRepository.save(nuevoProfesional);

	}

	public Profesional actualizarProfesional(Integer idProfesional, ActualizarProfesional request) {

		Profesional profesionalExistente = profesionalRepository.findById(idProfesional).orElse(null);

		if (profesionalExistente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesional con ID " + idProfesional + " no encontrado.");
		}

		validarEspecialidadExiste(request.getIdEspecialidad());

		profesionalExistente.setIdEspecialidad(request.getIdEspecialidad());

		return profesionalRepository.save(profesionalExistente);
	}



	public String eliminarProfesional(Integer idProfesional) {

		if (!profesionalRepository.existsById(idProfesional)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesional con ID " + idProfesional + " no encontrado.");
		}
	
		profesionalRepository.deleteById(idProfesional);
		return "Profesional eliminado correctamente.";
	}




	//MÉTODO DE APOYO: Conexión entre Microservicios
    private void validarUsuarioExiste(Integer idUsuario) {
        try {
            usuarioWebClient.get()
                .uri("/usuarios/{id}", idUsuario)
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede crear el profesional: El usuario con ID " + idUsuario + " no existe en el sistema.");
        }
    }

	private void validarEspecialidadExiste(Integer idEspecialidad){
		try {
			especialidadWebClient.get()
				.uri("/especialidades/{id}", idEspecialidad)
				.retrieve()
				.bodyToMono(EspecialidadDto.class)
				.block();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede crear el profesional: La especialidad con ID " + idEspecialidad + " no existe en el sistema.");
		}
	}


}
