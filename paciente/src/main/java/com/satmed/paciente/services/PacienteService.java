package com.satmed.paciente.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.paciente.models.dto.PacienteResponseDto;
import com.satmed.paciente.models.dto.UsuarioDto;
import com.satmed.paciente.models.entities.Paciente;
import com.satmed.paciente.repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private WebClient usuarioWebClient;

    public List<PacienteResponseDto> obtenerPacientes() {
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        List<PacienteResponseDto> listaResponse = new ArrayList<>();

        for (Paciente p : listaPacientes) {
            UsuarioDto usuario = obtenerUsuarioPorIdFallbackNull(p.getIdUsuario());
            listaResponse.add(new PacienteResponseDto(p.getIdPaciente(), usuario));
        }

        return listaResponse;
    }

    public PacienteResponseDto obtenerPacientePorId(Integer idPaciente) {
        Paciente pacienteEncontrado = pacienteRepository.findById(idPaciente).orElse(null);

        if (pacienteEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente con id: " + idPaciente + " no fue encontrado");
        }

        UsuarioDto usuario = obtenerUsuario(pacienteEncontrado.getIdUsuario());
        return new PacienteResponseDto(pacienteEncontrado.getIdPaciente(), usuario);
    }

    public Paciente crearPaciente(Paciente pacienteRequest) {
        validarUsuario(pacienteRequest.getIdUsuario());

        Paciente nuevoPaciente = new Paciente();
        nuevoPaciente.setIdUsuario(pacienteRequest.getIdUsuario());

        return pacienteRepository.save(nuevoPaciente);
    }

    public Paciente actualizarPaciente(Integer id, Paciente pacienteRequest) {
        Paciente pacienteExistente = pacienteRepository.findById(id).orElse(null);

        if (pacienteExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente con id: " + id + " no encontrado.");
        }

        validarUsuario(pacienteRequest.getIdUsuario());

        pacienteExistente.setIdUsuario(pacienteRequest.getIdUsuario());

        return pacienteRepository.save(pacienteExistente);
    }

    public String eliminarPaciente(Integer idPaciente) {
        Paciente pacienteEncontrado = pacienteRepository.findById(idPaciente).orElse(null);

        if (pacienteEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente con id: " + idPaciente + " no fue encontrado");
        }

        pacienteRepository.delete(pacienteEncontrado);
        return "Paciente con ID: " + idPaciente + " eliminado exitosamente";
    }

    //METODOS DE APOYO (Conexion MS usuario)
    private UsuarioDto obtenerUsuario(Integer idUsuario) {
        try {
            return usuarioWebClient.get()
                    .uri("/api/usuarios/{id}", idUsuario)
                    .retrieve()
                    .bodyToMono(UsuarioDto.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(e.getStatusCode(), "Error al conectarse con Microservicio usuarios: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Microservicio Usuarios apagado.");
        }
    }

    private void validarUsuario(Integer idUsuario) {
        try {
            usuarioWebClient.get()
                    .uri("/api/usuarios/{id}", idUsuario)
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario con id: " + idUsuario + " no encontrado para asociar al paciente.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Microservicio Usuarios apagado.");
        }
    }

    private UsuarioDto obtenerUsuarioPorIdFallbackNull(Integer idUsuario) {
        try {
            return usuarioWebClient.get()
                    .uri("/api/usuarios/{id}", idUsuario)
                    .retrieve()
                    .bodyToMono(UsuarioDto.class)
                    .block();
        } catch (Exception e) {
            return null; 
        }
    }
}