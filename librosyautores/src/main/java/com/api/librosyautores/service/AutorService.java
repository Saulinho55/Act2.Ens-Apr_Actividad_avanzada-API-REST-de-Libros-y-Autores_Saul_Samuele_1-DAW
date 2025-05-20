package com.api.librosyautores.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.api.librosyautores.model.Autor;
import com.api.librosyautores.repository.AutorRepository;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    
    public List<Autor> Listar() {
        return autorRepository.findAll();
    }

    public Autor BuscarPorAutor(Long ID) {
        return autorRepository.findById(ID).orElse(null);
    } 

    public Autor CrearAutor(Autor autor) {
        return autorRepository.save(autor);
    }
}
