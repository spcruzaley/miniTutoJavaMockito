package com.mini.tutorial.mockito.repository;

import com.mini.tutorial.mockito.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
