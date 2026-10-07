package com.example.biblioteca.demo.Controller;


import com.example.biblioteca.demo.Service.LivroService;
import com.example.biblioteca.demo.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvarLivro(livro);
    }

    @PutMapping("/{id}")
    public Livro editar(@PathVariable Long id, @RequestBody Livro livro) {
        return  livroService.editarLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        livroService.excluirLivro(id);
        return "Excluido com sucesso";
    }
}
