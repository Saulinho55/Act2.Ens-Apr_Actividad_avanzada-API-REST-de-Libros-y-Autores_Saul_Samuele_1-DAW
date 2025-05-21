package com.api.librosyautores.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.api.librosyautores.model.Autor;
import com.api.librosyautores.repository.AutorRepository;

@Service // Indica que esta clase es un servicio de Spring
public class AutorService {
    private final AutorRepository autorRepository; // Repositorio para acceder a los datos de Autor

    // Constructor para inyectar el repositorio
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    
    // Devuelve la lista de todos los autores
    public List<Autor> Listar() {
        return autorRepository.findAll();
    }

    // Busca un autor por su ID
    public Autor BuscarPorAutor(Long ID) {
        return autorRepository.findById(ID).orElse(null);
    } 

    // Crea un nuevo autor
    public Autor CrearAutor(Autor autor) {
        return autorRepository.save(autor);
    }
}
