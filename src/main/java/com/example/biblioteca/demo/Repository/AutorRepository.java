package com.example.biblioteca.demo.Repository;

import com.example.biblioteca.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
