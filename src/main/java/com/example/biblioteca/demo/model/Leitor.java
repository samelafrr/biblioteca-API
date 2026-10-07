package com.example.biblioteca.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Leitor")
@Getter
@Setter
@NoArgsConstructor
public class Leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLeitor;
    private String nome;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

    @ManyToMany
    @JoinTable(
            name = "leitor_livro",
            joinColumns = @JoinColumn(name = "leitor_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livro> livros;
}