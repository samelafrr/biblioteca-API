package com.example.biblioteca.demo.Repository;

import com.example.biblioteca.demo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
