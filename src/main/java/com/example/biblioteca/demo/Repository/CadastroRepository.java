package com.example.biblioteca.demo.Repository;

import com.example.biblioteca.demo.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro,Long> {
}
