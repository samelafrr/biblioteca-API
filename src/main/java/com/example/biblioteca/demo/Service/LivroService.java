package com.example.biblioteca.demo.Service;

import com.example.biblioteca.demo.Repository.LivroRepository;
import com.example.biblioteca.demo.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void excluirLivro(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Não é possível excluir");
        }
        livroRepository.deleteById(id);
    }

    public Livro editarLivro(Long id, Livro livroAtualizado) {
        Livro livroExistente = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro inexistente"));
        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setCategoria(livroAtualizado.getCategoria());

        return livroRepository.save(livroExistente);
    }
}
