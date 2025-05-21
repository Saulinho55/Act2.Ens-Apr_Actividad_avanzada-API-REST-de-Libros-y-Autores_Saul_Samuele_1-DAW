package com.api.librosyautores.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.librosyautores.model.Autor;
import com.api.librosyautores.service.AutorService;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/v1/autores") // Define la ruta base para las peticiones
public class AutorController {
    private AutorService autorService; // Servicio para la lógica de negocio de autores

    // Constructor para inyectar el servicio AutorService
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping // Maneja peticiones GET a /api/v1/autores
    public List<Autor> listar() {
        return autorService.Listar(); // Devuelve la lista de todos los autores
    }

    @GetMapping("/{id}") // Maneja peticiones GET a /api/v1/autores/{id}
    public Autor BuscarPorAutor(Long id) {
        return autorService.BuscarPorAutor(id); // Busca un autor por su ID
    }

    @PostMapping // Maneja peticiones POST a /api/v1/autores
    public Autor CrearAutor(Autor autor) {
        return autorService.CrearAutor(autor); // Crea un nuevo autor
    }
}
