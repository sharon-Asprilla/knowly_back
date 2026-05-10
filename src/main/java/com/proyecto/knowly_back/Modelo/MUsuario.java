package com.proyecto.knowly_back.Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class MUsuario {
    @Id
    @Column(length = 10, nullable = false)
    String ideusuario;

    @Column(length = 20, nullable = false)
    String rol;   // nuevo campo ( "ESTUDIANTE" o "PROFESOR")

    @Column(length = 90, nullable = false)
    String nombre;

    @Column(length = 90, nullable = false)
    String apellido;

    @Column(length = 50, nullable = false)
    String documento;

    @Column(length = 100, nullable = false)
    String correo;

    @Column(length = 8, nullable = false)
    String contrasenia;


    //relaciones

    // Relación: profesor → cursos
    @OneToMany(mappedBy = "mprofesor")
    @JsonManagedReference //evita problemas de recursividad infinita al serializar las relaciones en JSON
    private List<MCursos> mcursos;

    // Relación: estudiante → inscripciones
    @OneToMany(mappedBy = "mUsuario")   // debe coincidir con el atributo en MInscripciones
    @JsonManagedReference (value = "usuario-inscripcion")
    private List<MInscripciones> minscripciones;

    // Relación: estudiante → certificados
    @OneToMany(mappedBy = "mUsuario")   // debe coincidir con el atributo en MCertificado
    @JsonManagedReference (value = "usuario-certificado")
    private List<MCertificado> mCertificados;

    // constructor
    public MUsuario(String ideusuario, String rol, String nombre, String apellido, String documento, String correo, String contrasenia) {
        this.ideusuario = ideusuario;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public MUsuario() {

    }

    //encapsulamiento

    public String getIdeusuario() {
        return ideusuario;
    }

    public void setIdeusuario(String ideusuario) {
        this.ideusuario = ideusuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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