package com.proyecto.knowly_back.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class MCursos {

    @Id
    @Column(name = "idecursos", length = 15, nullable = false)
    String ideCursos;

    @Column(length = 80, nullable = false)
    String nombreCursos;

    @Column(length = 250, nullable = false)
    String descripcion;

    @Column(nullable = false)
    Integer precio;

    @Column(length = 30, nullable = false)
    String duracion;

    // relaciones

    // constructores
    public MCursos(String ideCursos, String nombreCursos, String descripcion, Integer precio, String duracion) {
        this.ideCursos = ideCursos;
        this.nombreCursos = nombreCursos;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
    }

    public MCursos() {
    }

    public String getIdeCursos() {
        return ideCursos;
    }

    public void setIdeCursos(String ideCursos) {
        this.ideCursos = ideCursos;
    }

    public String getNombreCursos() {
        return nombreCursos;
    }

    public void setNombreCursos(String nombreCursos) {
        this.nombreCursos = nombreCursos;
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
