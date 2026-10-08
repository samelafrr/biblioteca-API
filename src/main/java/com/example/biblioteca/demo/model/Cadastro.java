package com.example.biblioteca.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cadastro")
@Getter
@Setter
@NoArgsConstructor
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCadastro;
    private String nome;
    private String cpf;

    @OneToOne
    @JoinColumn(name = "cadastro_id", unique = true)
    private Leitor leitor;

}