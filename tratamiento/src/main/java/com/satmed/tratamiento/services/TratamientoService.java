package com.satmed.tratamiento.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.tratamiento.models.entities.Tratamiento;
import com.satmed.tratamiento.models.request.ActualizarTratamiento;
import com.satmed.tratamiento.models.request.AgregarTratamiento;
import com.satmed.tratamiento.repositories.TratamientoRepository;

@Service
public class TratamientoService {
    
    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<Tratamiento> obtenerTratamientos(){
        return tratamientoRepository.findAll();
    }

    public List<Tratamiento> obtenerTratamientosPorAtencionMedica(Integer idAtencionMedica){
     
        //Agregar metodo para validar que el idAtencionMedica exista en la tabla de atenciones medicas - Cuando veamos conexciones con otros microservicios

        return tratamientoRepository.findByIdAtencionMedica(idAtencionMedica);
    }

    public Tratamiento obtenerTratamientoPorId(Integer idTratamiento){

        Tratamiento tratamiento = tratamientoRepository.findById(idTratamiento).orElse(null);

        if(tratamiento == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El tratamiento con ID: " + idTratamiento + " No fue encontrado");
        }

        return tratamiento;

    }


    public Tratamiento crearTratamiento(AgregarTratamiento nuevoTratamiento) {

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setDescripcionTratamiento(nuevoTratamiento.getDescripcionTratamiento());
        tratamiento.setFechaInicio(LocalDate.now());
        tratamiento.setFechaFin(nuevoTratamiento.getFechaFin());
        tratamiento.setIdAtencionMedica(nuevoTratamiento.getIdAtencioMedica());
        tratamiento.setIdEstadoTratamiento(1);

        return tratamientoRepository.save(tratamiento);

    }


    public Tratamiento actualizarTratamiento(Integer idTratamiento, ActualizarTratamiento tratamientoActualizado) {

        Tratamiento tratamiento = tratamientoRepository.findById(idTratamiento).orElse(null);

        if(tratamiento == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El tratamiento con ID: " + idTratamiento + " No fue encontrado");
        }

        tratamiento.setDescripcionTratamiento(tratamientoActualizado.getDescripcionTratamiento());
        tratamiento.setFechaFin(tratamientoActualizado.getFechaFin());
        tratamiento.setIdEstadoTratamiento(tratamientoActualizado.getIdEstadoTratamiento());

        return tratamientoRepository.save(tratamiento);

    }


    public void eliminarTratamiento(Integer idTratamiento) {
        
    Tratamiento tratamiento = tratamientoRepository.findById(idTratamiento).orElse(null);
    
    if (tratamiento == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede eliminar: ID no encontrado");
    }
    
    tratamientoRepository.deleteById(idTratamiento);
}



}
