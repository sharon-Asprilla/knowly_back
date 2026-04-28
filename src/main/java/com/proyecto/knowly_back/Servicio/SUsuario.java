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

    // adicionar registro de usuario con validación de rol
    public MUsuario addiccionarUsuario(MUsuario mUsuario) throws Exception {
        try {
            if (!mUsuario.getRol().equals("PROFESOR") && !mUsuario.getRol().equals("ESTUDIANTE")) {
                throw new Exception("Rol inválido. Debe ser PROFESOR o ESTUDIANTE");
            }
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


    public List<MUsuario> consultaPorRol(String rol) throws Exception {
        try {
            return iUsuario.findByRol(rol);
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

    // modificar un registro de usuario incluyendo rol
    public MUsuario modificarUsuario(String ideUsuario, MUsuario mUsuario) throws Exception {
        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(ideUsuario);
            if (registroEncontrado.isPresent()) {
                MUsuario nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdeusuario(mUsuario.getIdeusuario());
                nuevoRegistro.setNombre(mUsuario.getNombre());
                nuevoRegistro.setApellido(mUsuario.getApellido());
                nuevoRegistro.setCorreo(mUsuario.getCorreo());
                nuevoRegistro.setContrasenia(mUsuario.getContrasenia());
                nuevoRegistro.setDocumento(mUsuario.getDocumento());
                nuevoRegistro.setRol(mUsuario.getRol()); // aquí guarda el rol

                return iUsuario.save(nuevoRegistro);
            } else {
                throw new Exception("usuario no se puede modificar ya que no se encontró");
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
                nuevoRegistro.setIdeusuario(mUsuario.getIdeusuario());
                return iUsuario.save(nuevoRegistro);
            } else {
                throw new Exception("no se puede anular usuario no encontrado ");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
