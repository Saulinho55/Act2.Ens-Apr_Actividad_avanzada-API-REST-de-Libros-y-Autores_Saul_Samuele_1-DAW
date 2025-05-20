package com.api.librosyautores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.librosyautores.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    
}
