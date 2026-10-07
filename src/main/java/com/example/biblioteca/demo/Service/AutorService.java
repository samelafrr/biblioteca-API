package com.example.biblioteca.demo.Service;

import com.example.biblioteca.demo.Repository.AutorRepository;
import com.example.biblioteca.demo.model.Autor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository repository) {
        this.autorRepository = repository;
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void excluirAutor(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Não é possível excluir");
        }
        autorRepository.deleteById(id);
    }

    public Autor editarAutor(Long id, Autor autorAtualizado) {
        Autor autorExistente = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor inexistente"));
    autorExistente.setNome(autorAtualizado.getNome());
    autorExistente.setNacionalidade(autorAtualizado.getNacionalidade());

    return autorRepository.save(autorExistente);
    }
}
