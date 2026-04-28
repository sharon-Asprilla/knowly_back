package com.proyecto.knowly_back.Controlador;

import com.proyecto.knowly_back.Modelo.MUsuario;
import com.proyecto.knowly_back.Servicio.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class CUsuario {
    @Autowired
    SUsuario sUsuario;

    //adicion y registro de usuario

    @RequestMapping
    public ResponseEntity<?>addiccionarUsuario(@RequestBody MUsuario mUsuario) throws  Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sUsuario.addiccionarUsuario(mUsuario));
        }catch (Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    @GetMapping("/rol")
    public ResponseEntity<?> consultaPorRol(@RequestParam String rol) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.consultaPorRol(rol));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }



    // consulta general
    @GetMapping
    public ResponseEntity<?> consultaGeneralUsuario () throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.consultaGeneralUsuario());

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    //consulta general por la llave primaria
    @GetMapping ("/{ideUsuario}")
    public  ResponseEntity<?> consultaIndicualId(@PathVariable String ideUsuario) throws Exception{
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.consultaIndividualId(ideUsuario));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }


    // consulta por nombre

    @GetMapping("/nombre")
    public  ResponseEntity<?> consultaIndividualNombre(@RequestParam String nombre) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.consultaIndividualNombre(nombre));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }


    @PutMapping("/{ideUsuario}")
    public  ResponseEntity<?> modificarUsuario(@PathVariable String ideUsuario, @RequestBody MUsuario mUsuario) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body((this.sUsuario.modificarUsuario(ideUsuario,mUsuario)));

        }catch (Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    //eliminar  un registro de usuario

    @DeleteMapping("/{ideUsuario}")
    public  ResponseEntity<?> eliminarUsuario(@PathVariable String ideUsuario) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.eliminarUsuario(ideUsuario));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }










}
