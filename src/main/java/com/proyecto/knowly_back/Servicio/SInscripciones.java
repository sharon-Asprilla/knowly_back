package com.proyecto.knowly_back.Servicio;

import java.util.List;
import java.util.Optional;

import com.proyecto.knowly_back.Modelo.MInscripciones;
import com.proyecto.knowly_back.Repositorio.IInscripciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class SInscripciones {
    @Autowired
    IInscripciones iInscripciones;

    public SInscripciones(IInscripciones IInscripciones) {
        this.iInscripciones = IInscripciones;
    }

    public MInscripciones addiccionarInscripcion(MInscripciones mInscripciones) throws Exception {
        try {
            return iInscripciones.save(mInscripciones);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<MInscripciones> consultaGeneralInscripcion() throws Exception {
        try {
            return iInscripciones.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public MInscripciones consultaIndividualId(String ideInscripcion) throws Exception {
        try {
            Optional<MInscripciones> registro = iInscripciones.findById(ideInscripcion);
            if (registro.isPresent())
                return registro.get();
            else
                throw new Exception("inscripción no encontrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarInscripcion(String ideInscripcion) throws Exception {
        try {
            Optional<MInscripciones> registro = iInscripciones.findById(ideInscripcion);
            if (registro.isPresent()) {
                iInscripciones.deleteById(ideInscripcion);
                return true;
            } else {
                throw new Exception("inscripción no encontrada para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<MInscripciones> buscarInscripcionesPorDocumento(String documento) throws Exception {
        try {
            return iInscripciones.buscarInscripciones(documento);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
