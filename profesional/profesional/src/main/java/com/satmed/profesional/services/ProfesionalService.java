package com.satmed.profesional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.satmed.profesional.model.entities.Profesional;
import com.satmed.profesional.model.request.ActualizarProfesional;
import com.satmed.profesional.model.request.AgregarProfesional;
import com.satmed.profesional.repositories.ProfesionalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfesionalService {

	private final ProfesionalRepository profesionalRepository;

	public List<Profesional> listarTodos() {
		return profesionalRepository.findAll();
	}

	public Optional<Profesional> buscarPorId(Integer id) {
		return profesionalRepository.findById(id);
	}

	@Transactional
	public Profesional agregar(AgregarProfesional request) {
		Profesional entity = new Profesional();
		entity.setNumeroRegistroProfesional(request.getNumeroRegistroProfesional());
		entity.setActivoProfesional(request.getActivoProfesional());
		return profesionalRepository.save(entity);
	}

	@Transactional
	public Optional<Profesional> actualizar(Integer id, ActualizarProfesional request) {
		return profesionalRepository.findById(id).map(existing -> {
			existing.setNumeroRegistroProfesional(request.getNumeroRegistroProfesional());
			existing.setActivoProfesional(request.getActivoProfesional());
			return profesionalRepository.save(existing);
		});
	}

	/**
	 * Eliminación lógica: desactiva el registro. Eliminación física: borra de la base de datos.
	 */
	@Transactional
	public boolean eliminar(Integer id, boolean fisico) {
		Optional<Profesional> opt = profesionalRepository.findById(id);
		if (opt.isEmpty()) {
			return false;
		}
		if (fisico) {
			profesionalRepository.deleteById(id);
		} else {
			Profesional p = opt.get();
			p.setActivoProfesional(false);
			profesionalRepository.save(p);
		}
		return true;
	}
}
