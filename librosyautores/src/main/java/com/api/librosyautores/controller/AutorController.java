package com.api.librosyautores.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.librosyautores.model.Autor;
import com.api.librosyautores.service.AutorService;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {
    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listar() {
        return autorService.Listar();
    }

    @GetMapping("/{id}")
    public Autor BuscarPorAutor(Long id) {
        return autorService.BuscarPorAutor(id);
    }

    @PostMapping
    public Autor CrearAutor(Autor autor) {
        return autorService.CrearAutor(autor);
    }
}
