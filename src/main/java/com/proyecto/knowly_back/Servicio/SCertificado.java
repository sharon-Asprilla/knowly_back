package com.proyecto.knowly_back.Servicio;

import com.proyecto.knowly_back.Modelo.MCertificado;
import com.proyecto.knowly_back.Repositorio.ICertificado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCertificado {
    @Autowired
    ICertificado iCertificado;

    public SCertificado(ICertificado ICertificado) {
        this.iCertificado = ICertificado;
    }

    public MCertificado addiccionarCertificado(MCertificado mCertificado) throws Exception {
        try {
            return iCertificado.save(mCertificado);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<MCertificado> consultaGeneralCertificado() throws Exception {
        try {
            return iCertificado.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public MCertificado consultaIndividualId(String ideCertificado) throws Exception {
        try {
            Optional<MCertificado> registro = iCertificado.findById(ideCertificado);
            if (registro.isPresent())
                return registro.get();
            else
                throw new Exception("certificado no encontrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarCertificado(String ideCertificado) throws Exception {
        try {
            Optional<MCertificado> registro = iCertificado.findById(ideCertificado);
            if (registro.isPresent()) {
                iCertificado.deleteById(ideCertificado);
                return true;
            } else {
                throw new Exception("certificado no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


}
