package com.api.librosyautores.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.librosyautores.model.Libro;
import com.api.librosyautores.service.LibroService;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/v1/libros") // Ruta base para las peticiones relacionadas con libros
public class LibroController {
    private LibroService libroService; // Servicio para la lógica de negocio de libros

    // Constructor para inyectar el servicio LibroService
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping // Maneja peticiones GET a /api/v1/libros
    public List<Libro> ListarLibros() {
        return libroService.ListarLibros(); // Devuelve la lista de todos los libros
    }

    @GetMapping("/{id}") // Maneja peticiones GET a /api/v1/libros/{id}
    public Libro BuscarPorID(@PathVariable Long id) {
        return libroService.BuscarPorID(id); // Busca un libro por su ID
    }

    @PostMapping // Maneja peticiones POST a /api/v1/libros
    public Libro Crear(@RequestBody Libro libro) {
        return libroService.Crear(libro); // Crea un nuevo libro
    }

    @PostMapping("/{id}") // Maneja peticiones POST a /api/v1/libros/{id} para actualizar
    public Libro Actualizar(@PathVariable Long id, @RequestBody Libro libroAct) {
        return libroService.Actualizar(id, libroAct); // Actualiza un libro existente
    }

    @DeleteMapping("/{id}") // Maneja peticiones DELETE a /api/v1/libros/{id}
    public void Eliminar(Long id) {
        libroService.Eliminar(id); // Elimina un libro por su ID
    }

    @GetMapping("/buscar") // Maneja peticiones GET a /api/v1/libros/buscar con filtros
    public List<Libro> BuscarLibros(
        @RequestParam(required = false) String titulo, // Filtro por título
        @RequestParam(required = false) Integer anio, // Filtro por año
        @RequestParam(required = false) String sortBy, // Ordenar por campo
        @RequestParam(required = false, defaultValue = "asc") String order) // Orden ascendente/descendente
        {
        return libroService.BuscarLibros(titulo, anio, sortBy, order); // Busca libros según los filtros
    }
}
