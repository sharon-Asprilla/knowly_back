package com.proyecto.knowly_back.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "curso")
public class MCurso {

    @Id
    @Column(name = "idecurso",length = 15,nullable = false)
    String ideCurso;

    @Column (length = 80,nullable = false)
    String nombreCurso;

    @Column (length = 250,nullable = false)
    String descripcion;

    @Column (nullable = false)
    Integer precio;

    @Column (length = 30,nullable = false)
    String duracion;

    //relaciones

    //constructores


    public MCurso(String ideCurso, String nombreCurso, String descripcion, Integer precio, String duracion) {
        this.ideCurso = ideCurso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
    }

    public MCurso() {
    }

    public String getIdeCurso() {
        return ideCurso;
    }

    public void setIdeCurso(String ideCurso) {
        this.ideCurso = ideCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
