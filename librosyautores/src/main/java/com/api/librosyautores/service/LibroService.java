package com.api.librosyautores.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.librosyautores.model.Libro;
import com.api.librosyautores.model.Autor;
import com.api.librosyautores.repository.LibroRepository;
import com.api.librosyautores.repository.AutorRepository;

@Service // Indica que esta clase es un servicio de Spring
public class LibroService {
    private final LibroRepository libroRepository; // Repositorio para acceder a los datos de Libro
    private final AutorRepository autorRepository; // Repositorio para acceder a los datos de Autor

    // Constructor para inyectar los repositorios
    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    // Devuelve la lista de todos los libros
    public List<Libro> ListarLibros() {
        return libroRepository.findAll();
    }

    // Busca un libro por su ID
    public Libro BuscarPorID(Long ID) {
        return libroRepository.findById(ID).orElse(null);
    }

    // Crea un nuevo libro
    public Libro Crear(Libro libro) {
        Autor autor = autorRepository.findById(libro.getAutor().getId()).orElse(null);
        if (autor != null) {
            libro.setAutor(autor);
            return libroRepository.save(libro);
        } else {
            return null;
        }
    }

    // Actualiza un libro existente
    public Libro Actualizar(Long id, Libro LibroAct) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if (libro != null) {
            libro.setTitulo(LibroAct.getTitulo());
            libro.setIsbn(LibroAct.getIsbn());
            libro.setAnioPublicacion(LibroAct.getAnioPublicacion());
            if (LibroAct.getAutor() != null) {
                Autor autor = autorRepository.findById(LibroAct.getAutor().getId()).orElse(null);
                if (autor != null) {
                    libro.setAutor(autor);
                }
            }
            return libroRepository.save(libro);
        }
        return null;
    }

    // Elimina un libro por su ID
    public void Eliminar(Long id) {
        libroRepository.deleteById(id);
    }

    // Busca libros según filtros de título, año y ordenamiento
    public List<Libro> BuscarLibros(String titulo, Integer anio, String sortBy, String order) {
        Sort sort = Sort.unsorted();
        if (sortBy != null && !sortBy.isEmpty()) {
            sort = "desc".equalsIgnoreCase(order) ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        }
        List<Libro> libros = libroRepository.findAll(sort);
        // Filtra por título y año si se proporcionan
        return libros.stream()
            .filter(l -> titulo == null || l.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
            .filter(l -> anio == null || l.getAnioPublicacion() == anio)
            .toList();
    }
}
