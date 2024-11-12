package com.mini.tutorial.mockito.controller;

import com.mini.tutorial.mockito.entity.Autor;
import com.mini.tutorial.mockito.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorService autorService;

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.guardar(autor);
    }

    @GetMapping
    public List<Autor> obtenerAutores() {
        return autorService.obtenerTodos();
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) throws RuntimeException {
        autorService.eliminar(id);
    }
}
