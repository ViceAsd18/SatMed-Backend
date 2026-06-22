package com.satmed.atencion_medica.servcies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satmed.atencion_medica.models.entities.AtencionMedica;
import com.satmed.atencion_medica.models.entities.BitacoraAtencion;
import com.satmed.atencion_medica.models.request.ActualizarAtencionRequest;
import com.satmed.atencion_medica.models.request.RegistrarAtencionRequest;
import com.satmed.atencion_medica.models.request.RegistrarBitacoraRequest;
import com.satmed.atencion_medica.repositories.AtencionMedicaRepository;
import com.satmed.atencion_medica.repositories.BitacoraAtencionRepository;

@Service
public class AtencionMedicaService {

    @Autowired
    private AtencionMedicaRepository atencionRepository;

    @Autowired
    private BitacoraAtencionRepository bitacoraRepository;

    public AtencionMedica registrarNuevaAtencionMedica(RegistrarAtencionRequest request) {
        AtencionMedica atencion = new AtencionMedica();
        atencion.setFechaAtencion(request.getFechaAtencion());
        atencion.setMotivo(request.getMotivo().trim());
        atencion.setDiagnostico(request.getDiagnostico().trim());
        atencion.setIndicaciones(request.getIndicaciones().trim());
        atencion.setIdProfesional(request.getIdProfesional());
        atencion.setIdPaciente(request.getIdPaciente());

        return atencionRepository.save(atencion);
    }

    public AtencionMedica modificarAtencionMedica(ActualizarAtencionRequest request) {
        AtencionMedica atencionExistente = obtenerDetalleDeAtencionPorId(request.getIdAtencion());

        atencionExistente.setFechaAtencion(request.getFechaAtencion());
        atencionExistente.setMotivo(request.getMotivo().trim());
        atencionExistente.setDiagnostico(request.getDiagnostico().trim());
        atencionExistente.setIndicaciones(request.getIndicaciones().trim());

        return atencionRepository.save(atencionExistente);
    }

    public BitacoraAtencion registrarEventoEnBitacora(RegistrarBitacoraRequest request) {
        AtencionMedica atencion = atencionRepository.findById(request.getIdAtencion())
                .orElseThrow(() -> new RuntimeException("Error: No se puede registrar en bitácora porque la atención médica con ID " + request.getIdAtencion() + " no existe."));

        BitacoraAtencion bitacora = new BitacoraAtencion();
        bitacora.setDescripcion(request.getDescripcion().trim());
        bitacora.setIdTipoEvento(request.getIdTipoEvento());
        bitacora.setIdUsuario(request.getIdUsuario());
        bitacora.setAtencionMedica(atencion);
        
        String ahora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        bitacora.setFechaHoraRealizada(ahora);

        return bitacoraRepository.save(bitacora);
    }

    public AtencionMedica obtenerDetalleDeAtencionPorId(Long idAtencion) {
        return atencionRepository.findById(idAtencion)
                .orElseThrow(() -> new RuntimeException("Error: El registro de atención médica con ID " + idAtencion + " no fue encontrado."));
    }

    public List<AtencionMedica> obtenerHistorialClinicoPorPaciente(Long idPaciente) {
        return atencionRepository.findByIdPaciente(idPaciente);
    }

    public List<BitacoraAtencion> obtenerBitacoraDeAtencion(Long idAtencion) {
        return bitacoraRepository.findByAtencionMedicaIdAtencion(idAtencion);
    }
}