package com.api.librosyautores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.librosyautores.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
