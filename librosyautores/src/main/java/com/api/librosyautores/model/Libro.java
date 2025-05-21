package com.api.librosyautores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity // Indica que esta clase es una entidad JPA
public class Libro {
    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id;
    private String titulo; // Título del libro
    private String isbn; // ISBN del libro
    private int anioPublicacion; // Año de publicación

    @ManyToOne // Muchos libros pueden pertenecer a un autor
    @JoinColumn(name = "autor_id") // Nombre de la columna de la clave foránea
    private Autor autor; // Autor al que pertenece el libro

    // Getter para id
    public Long getId() {
        return id;
    }

    // Setter para id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para título
    public String getTitulo() {
        return titulo;
    }

    // Setter para título
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter para ISBN
    public String getIsbn() {
        return isbn;
    }

    // Setter para ISBN
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getter para año de publicación
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    // Setter para año de publicación
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    // Getter para autor
    public Autor getAutor() {
        return autor;
    }

    // Setter para autor
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}