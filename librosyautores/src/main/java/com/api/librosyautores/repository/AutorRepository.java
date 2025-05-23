package com.api.librosyautores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.librosyautores.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
