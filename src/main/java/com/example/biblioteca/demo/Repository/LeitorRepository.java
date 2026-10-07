package com.example.biblioteca.demo.Repository;

import com.example.biblioteca.demo.model.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<Leitor, Long> {
}
