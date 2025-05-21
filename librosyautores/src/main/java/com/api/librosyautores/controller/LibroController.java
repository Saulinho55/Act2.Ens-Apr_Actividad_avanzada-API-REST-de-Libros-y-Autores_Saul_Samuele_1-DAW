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

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    private LibroService libroService;
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> ListarLibros() {
        return libroService.ListarLibros();
    }

    @GetMapping("/{id}")
    public Libro BuscarPorID(@PathVariable Long id) {
        return libroService.BuscarPorID(id);
    }

    @PostMapping
    public Libro Crear(@RequestBody Libro libro) {
        return libroService.Crear(libro);
    }

    @PostMapping("/{id}")
    public Libro Actualizar(@PathVariable Long id, @RequestBody Libro libroAct) {
        return libroService.Actualizar(id, libroAct);
    }

    @DeleteMapping("/{id}")
    public void Eliminar(Long id) {
        libroService.Eliminar(id);
    }

    @GetMapping("/buscar")
    public List<Libro> BuscarLibros(
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) Integer anio,
        @RequestParam(required = false) String sortBy,
        @RequestParam(required = false, defaultValue = "asc") String order) 
        {
        return libroService.BuscarLibros(titulo, anio, sortBy, order);
    }
}
