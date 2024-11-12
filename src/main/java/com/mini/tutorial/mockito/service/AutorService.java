package com.mini.tutorial.mockito.service;

import com.mini.tutorial.mockito.entity.Autor;
import com.mini.tutorial.mockito.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public void eliminar(Long id) throws RuntimeException {
        if (id == null || id <= 0) {
            throw new RuntimeException("ID inválido para eliminación");
        }
        autorRepository.deleteById(id);
    }
}
