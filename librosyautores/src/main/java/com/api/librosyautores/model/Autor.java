package com.api.librosyautores.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // Indica que esta clase es una entidad JPA
public class Autor {
    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private long id;
    private String nombre; // Nombre del autor
    private String nacionalidad; // Nacionalidad del autor

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true) // Relación uno a muchos con Libro
    @JsonManagedReference 
    private List<Libro> libros = new ArrayList<>(); // Lista de libros asociados al autor

    // Getter para id
    public long getId() {
        return id;
    }

    // Setter para id
    public void setId(long id) {
        this.id = id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para nacionalidad
    public String getNacionalidad() {
        return nacionalidad;
    }

    // Setter para nacionalidad
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Getter para la lista de libros
    public List<Libro> getLibros() {
        return libros;
    }

    // Setter para la lista de libros
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
