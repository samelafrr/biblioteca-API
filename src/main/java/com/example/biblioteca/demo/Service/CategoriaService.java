package com.example.biblioteca.demo.Service;

import com.example.biblioteca.demo.Repository.CategoriaRepository;
import com.example.biblioteca.demo.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void excluirCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Não é possível excluir");
        }
        categoriaRepository.deleteById(id);
    }

    public Categoria editarCategoria(Long id, Categoria categoriaAtualizada) {
        Categoria categoriaExistente= categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria inexistente"));
        categoriaExistente.setNome(categoriaAtualizada.getNome());
        categoriaExistente.setDescricao(categoriaAtualizada.getDescricao());

        return categoriaRepository.save(categoriaExistente);
    }
}
