package com.proyecto.knowly_back.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class MUsuario {
    @Id
    @Column(name="idusuario",length = 10,nullable=false)
    String ideUsuario;

    @Column (length = 90,nullable = false)
    String nombre;

    @Column(length = 90,nullable = false)
    String apellido;

    @Column(length = 50,nullable = false)
    String documento;

    @Column(length = 100,nullable = false)
    String correo;

    @Column(length = 8,nullable = false)
    String contrasenia;

    //relaciones

    // constructor

    public MUsuario(String ideUsuario, String nombre, String apellido, String documento, String correo, String contrasenia) {
        this.ideUsuario = ideUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public MUsuario() {
    }

    //encapsulamiento


    public String getIdeUsuario() {
        return ideUsuario;
    }

    public void setIdeUsuario(String ideUsuario) {
        this.ideUsuario = ideUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
