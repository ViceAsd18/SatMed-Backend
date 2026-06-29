package com.satmed.reunion_clinica.services;

import com.satmed.reunion_clinica.models.entities.*;
import com.satmed.reunion_clinica.models.request.BitacoraRequest;
import com.satmed.reunion_clinica.models.request.ReunionRequest;
import com.satmed.reunion_clinica.repositories.BitacoraReunionRepository;
import com.satmed.reunion_clinica.repositories.ConvocaRepository;
import com.satmed.reunion_clinica.repositories.ReunionClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReunionClinicaService {

    @Autowired
    private ReunionClinicaRepository reunionRepository;

    @Autowired
    private ConvocaRepository convocaRepository;

    @Autowired
    private BitacoraReunionRepository bitacoraRepository;

    @Transactional
    public ReunionClinica crearReunion(ReunionRequest request) {
        
        //Guar la reunión básica
        ReunionClinica reunion = new ReunionClinica();
        reunion.setFechaRealizada(request.getFechaRealizada());
        reunion.setDescripcionReunion(request.getDescripcionReunion());
        
        ReunionClinica reunionGuardada = reunionRepository.save(reunion);

        //Registramos a los médicos invitados en la intermedia 'convoca'
        if (request.getIdProfesionalesInvitados() != null && !request.getIdProfesionalesInvitados().isEmpty()) {
            for (Long idProf : request.getIdProfesionalesInvitados()) {
                Convoca convoca = new Convoca();
                ConvocaId idCompuesto = new ConvocaId();
                
                idCompuesto.setIdProfesional(idProf);
                idCompuesto.setIdReunion(reunionGuardada.getIdReunion());
                
                convoca.setId(idCompuesto);
                convoca.setReunionClinica(reunionGuardada);
                
                convocaRepository.save(convoca);
            }
        }
        return reunionGuardada;
    }

    public List<ReunionClinica> listarReuniones() {
        return reunionRepository.findAll();
    }

    public ReunionClinica buscarReunionPorId(Long id) {
        return reunionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la reunión: " + id));
    }

    @Transactional
    public BitacoraReunion crearBitacora(BitacoraRequest request) {
        ReunionClinica reunion = buscarReunionPorId(request.getIdReunion());

        BitacoraReunion bitacora = new BitacoraReunion();
        bitacora.setDescripcion(request.getDescripcion());
        bitacora.setFechaEmision(request.getFechaEmision());
        bitacora.setReunionClinica(reunion);
        bitacora.setIdTipoEvento(request.getIdTipoEvento());

        return bitacoraRepository.save(bitacora);
    }

    public List<BitacoraReunion> listarBitacorasPorReunion(Long idReunion) {
        return bitacoraRepository.findByReunionClinicaIdReunion(idReunion);
    }
}
