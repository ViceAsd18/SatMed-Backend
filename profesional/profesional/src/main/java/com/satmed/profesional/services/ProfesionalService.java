package com.satmed.profesional.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.profesional.models.dto.UsuarioDto;
import com.satmed.profesional.models.entities.Profesional;
import com.satmed.profesional.models.request.AgregarProfesional;
import com.satmed.profesional.repositories.ProfesionalRepository;


@Service
public class ProfesionalService {

	@Autowired	
	private ProfesionalRepository profesionalRepository;

	@Autowired
	private WebClient usuarioWebClient;


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

		Profesional nuevoProfesional = new Profesional();
		nuevoProfesional.setIdUsuario(request.getIdUsuario());
		nuevoProfesional.setNumeroRegistroProfesional(request.getNumeroRegistroProfesional());

		//(HACER) validar que la especialidad
		nuevoProfesional.setIdEspecialidad(request.getIdEspecialidad());	

		return profesionalRepository.save(nuevoProfesional);

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


}
