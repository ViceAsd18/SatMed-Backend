package com.satmed.atencion_medica.servcies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satmed.atencion_medica.models.entities.AtencionMedica;
import com.satmed.atencion_medica.models.entities.Interconsulta;
import com.satmed.atencion_medica.models.request.ActualizarInterconsultaRequest;
import com.satmed.atencion_medica.models.request.RegistrarInterconsultaRequest;
import com.satmed.atencion_medica.repositories.AtencionMedicaRepository;
import com.satmed.atencion_medica.repositories.InterconsultaRepository;

@Service
public class InterconsultaService {
    
@Autowired
    private InterconsultaRepository interconsultaRepository;

    @Autowired
    private AtencionMedicaRepository atencionRepository;

    public Interconsulta registrarInterconsulta(RegistrarInterconsultaRequest request) {
        // Verificar que exista la atención médica de origen
        AtencionMedica atencion = atencionRepository.findById(request.getIdAtencion())
                .orElseThrow(() -> new RuntimeException("Error: No existe la atención médica con ID " + request.getIdAtencion()));

        Interconsulta inter = new Interconsulta();
        inter.setMotivo(request.getMotivo().trim());
        inter.setFechaEmision(request.getFechaEmision());
        inter.setAtencionMedica(atencion);
        inter.setIdProfesional(request.getIdProfesional());

        return interconsultaRepository.save(inter);
    }

    public Interconsulta modificarInterconsulta(ActualizarInterconsultaRequest request) {
        Interconsulta existente = buscarPorId(request.getIdInterconsulta());
        
        existente.setMotivo(request.getMotivo().trim());
        existente.setFechaEmision(request.getFechaEmision());

        return interconsultaRepository.save(existente);
    }

    public Interconsulta buscarPorId(Long idInterconsulta) {
        return interconsultaRepository.findById(idInterconsulta)
                .orElseThrow(() -> new RuntimeException("Error: Interconsulta no encontrada con ID " + idInterconsulta));
    }

    public List<Interconsulta> listarPorAtencion(Long idAtencion) {
        return interconsultaRepository.findByAtencionMedicaIdAtencion(idAtencion);
    }

    public List<Interconsulta> listarPorProfesional(Long idProfesional) {
        return interconsultaRepository.findByIdProfesional(idProfesional);
    }

}
