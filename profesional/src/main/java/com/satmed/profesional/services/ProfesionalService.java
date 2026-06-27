package com.satmed.profesional.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.profesional.models.dto.EspecialidadDto;
import com.satmed.profesional.models.dto.ProfesionalResponseDto;
import com.satmed.profesional.models.dto.UsuarioDto;
import com.satmed.profesional.models.entities.Profesional;
import com.satmed.profesional.models.request.ActualizarProfesional;
import com.satmed.profesional.models.request.AgregarProfesional;
import com.satmed.profesional.repositories.ProfesionalRepository;

@Service
public class ProfesionalService {

    @Autowired  
    private ProfesionalRepository profesionalRepository;

    // Los nombres de las variables calzan EXACTAMENTE con tus @Bean de WebClientConfig
    @Autowired
    private WebClient usuarioWebClient;

    @Autowired
    private WebClient especialidadWebClient;

    public List<ProfesionalResponseDto> obtenerTodosLosProfesionales() {
        List<Profesional> lista = profesionalRepository.findAll();
        return lista.stream().map(p -> {
            UsuarioDto user = obtenerUsuarioFallbackNull(p.getIdUsuario());
            EspecialidadDto esp = obtenerEspecialidadFallbackNull(p.getIdEspecialidad());
            return new ProfesionalResponseDto(p.getIdProfesional(), p.getNumeroRegistroProfesional(), user, esp);
        }).toList();
    }

    public ProfesionalResponseDto obtenerProfesionalPorId(Integer idProfesional) {
        Profesional profesionalEncontrado = profesionalRepository.findById(idProfesional).orElse(null);

        if (profesionalEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesional con ID " + idProfesional + " no encontrado.");
        }

        UsuarioDto user = obtenerUsuarioFallbackNull(profesionalEncontrado.getIdUsuario());
        EspecialidadDto esp = obtenerEspecialidadFallbackNull(profesionalEncontrado.getIdEspecialidad());
        return new ProfesionalResponseDto(profesionalEncontrado.getIdProfesional(), profesionalEncontrado.getNumeroRegistroProfesional(), user, esp);
    }

    public Profesional agregarProfesional(AgregarProfesional request){

        validarUsuarioExiste(request.getIdUsuario());
        validarEspecialidadExiste(request.getIdEspecialidad());

        if (profesionalRepository.existsByIdUsuario(request.getIdUsuario())) {
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

    public Profesional actualizarProfesional(ActualizarProfesional request) {

        Profesional profesionalExistente = profesionalRepository.findById(request.getIdProfesional()).orElse(null);

        if (profesionalExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesional con ID " + request.getIdProfesional() + " no encontrado.");
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

    // ========================================================
    // MÉTODOS DE APOYO: VALIDACIONES (Rutas relativas limpias)
    // ========================================================
    
    private void validarUsuarioExiste(Integer idUsuario) {
        try {
            this.usuarioWebClient.get()
                .uri("/api/usuarios/" + idUsuario.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede crear el profesional: El usuario con ID " + idUsuario + " no existe en el sistema.");
        }
    }

    private void validarEspecialidadExiste(Integer idEspecialidad){
        try {
            this.especialidadWebClient.get()
                .uri("/especialidades/" + idEspecialidad.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede crear el profesional: La especialidad con ID " + idEspecialidad + " no existe en el sistema.");
        }
    }

    // ========================================================
    // MÉTODOS DE APOYO: FALLBACKS (Para listados y búsquedas)
    // ========================================================

    private UsuarioDto obtenerUsuarioFallbackNull(Integer idUsuario) {
        try {
            return this.usuarioWebClient.get()
                    .uri("/api/usuarios/" + idUsuario.toString())
                    .retrieve()
                    .bodyToMono(UsuarioDto.class)
                    .block();
        } catch (Exception e) {
            return null; 
        }
    }

    private EspecialidadDto obtenerEspecialidadFallbackNull(Integer idEspecialidad) {
        try {
            return this.especialidadWebClient.get()
                    .uri("/especialidades/" + idEspecialidad.toString())
                    .retrieve()
                    .bodyToMono(EspecialidadDto.class)
                    .block();
        } catch (Exception e) {
            return null; 
        }
    }
}