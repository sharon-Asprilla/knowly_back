package com.proyecto.knowly_back.Servicio;

import com.proyecto.knowly_back.Modelo.MUsuario;
import com.proyecto.knowly_back.Repositorio.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SUsuario {
    @Autowired
    IUsuario iUsuario;

    public SUsuario(IUsuario IUsuario) {
        this.iUsuario = IUsuario;
    }

    //adicion de registro de usuario

    public MUsuario addiccionarUsuario(MUsuario mUsuario) throws Exception {
        try {
            return iUsuario.save(mUsuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de usuario
    public List<MUsuario> consultaGeneralUsuario() throws Exception {

        try {
            return iUsuario.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public MUsuario consultaIndividualId(String ideUsuario) throws Exception {
        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(ideUsuario);

            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("usuario no encontrado ");

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta por nombre
    public List<MUsuario> consultaIndividualNombre(String nombre) throws Exception {
        try {
            return iUsuario.findByNombre(nombre);
        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // modificar un registro de usuario
    public MUsuario modificarUsuario(String ideUsuario, MUsuario mUsuario) throws Exception {

        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(ideUsuario);
            if (registroEncontrado.isPresent()) {
                MUsuario nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdeUsuario(mUsuario.getIdeUsuario());
                nuevoRegistro.setNombre(mUsuario.getNombre());
                nuevoRegistro.setApellido(mUsuario.getApellido());
                nuevoRegistro.setCorreo(mUsuario.getCorreo());
                nuevoRegistro.setContrasenia(mUsuario.getContrasenia());
                nuevoRegistro.setDocumento(mUsuario.getDocumento());

                return iUsuario.save(nuevoRegistro);
            } else {
                throw new Exception("usuario no se puede modificar ya que el usuario no se encontro ");

            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar un registro

    public boolean eliminarUsuario(String ideUsuario) throws Exception {
        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(ideUsuario);
            if (registroEncontrado.isPresent()) {
                iUsuario.deleteById((ideUsuario));
                return true;
            } else {
                throw new Exception("usuario no se puede eliminar porque el usuario no esta encontrado ");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //anular registro  de usuario

    public MUsuario anularUsuario(String ideUsuario, MUsuario mUsuario) throws Exception {
        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(ideUsuario);

            if (registroEncontrado.isPresent()) {
                MUsuario nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdeUsuario(mUsuario.getIdeUsuario());
                return iUsuario.save(nuevoRegistro);
            } else {
                throw new Exception("no se puede anular usuario no encontrado ");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
