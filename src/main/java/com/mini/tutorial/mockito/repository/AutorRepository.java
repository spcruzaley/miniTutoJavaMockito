package com.mini.tutorial.mockito.repository;

import com.mini.tutorial.mockito.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
