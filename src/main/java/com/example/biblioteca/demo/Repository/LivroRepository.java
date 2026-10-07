package com.example.biblioteca.demo.Repository;

import com.example.biblioteca.demo.model.Categoria;
import com.example.biblioteca.demo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
