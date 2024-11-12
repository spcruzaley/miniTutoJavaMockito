package com.mini.tutorial.mockito.service;

import com.mini.tutorial.mockito.entity.Libro;
import com.mini.tutorial.mockito.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    public void eliminar(Long id) {
        libroRepository.deleteById(id);
        libroRepository.deleteAllInBatch();
    }
}
