package com.proyecto.knowly_back.Servicio;

import com.proyecto.knowly_back.Modelo.MCursos;
import com.proyecto.knowly_back.Repositorio.ICursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCursos {
    @Autowired
    ICursos iCursos;

    public SCursos(ICursos ICursos) {
        this.iCursos= ICursos;
    }

    // adicionar registro de  curso
    public MCursos addiccionarCursos(MCursos mCursos) throws Exception {
        try {
            return iCursos.save(mCursos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de cursos
    public List<MCursos> consultaGeneralCursos() throws Exception {
        try {
            return iCursos.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual
    public MCursos consultaIndividualId(String ideCursos) throws Exception {
        try {
            Optional<MCursos> registro = iCursos.findById(ideCursos);
            if (registro.isPresent())
                return registro.get();
            else
                throw new Exception("curso no encontrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar curso
    public MCursos modificarCursos(String ideCursos, MCursos mCursos) throws Exception {
        try {
            Optional<MCursos>registro = iCursos.findById(ideCursos);
            if (registro.isPresent()) {
                MCursos nuevo = registro.get();
                nuevo.setNombreCursos(mCursos.getNombreCursos());
                nuevo.setDescripcion(mCursos.getDescripcion());
                nuevo.setPrecio(mCursos.getPrecio());
                nuevo.setDuracion(mCursos.getDuracion());
                return iCursos.save(nuevo);
            } else {
                throw new Exception("curso no encontrado para modificar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar curso
    public boolean eliminarCursos(String ideCursos) throws Exception {
        try {
            Optional<MCursos> registro = iCursos.findById(ideCursos);
            if (registro.isPresent()) {
                iCursos.deleteById(ideCursos);
                return true;
            } else {
                throw new Exception("curso no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
