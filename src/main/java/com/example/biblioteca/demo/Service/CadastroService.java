package com.example.biblioteca.demo.Service;

import com.example.biblioteca.demo.Repository.CadastroRepository;
import com.example.biblioteca.demo.Repository.LivroRepository;
import com.example.biblioteca.demo.model.Cadastro;
import com.example.biblioteca.demo.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public List<Cadastro> listarCadastros() {
        return cadastroRepository.findAll();
    }

    public Cadastro salvarCadastro(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    public void excluirCadastro(Long id) {
        if (!cadastroRepository.existsById(id)) {
            throw new RuntimeException("Não é possível excluir");
        }
        cadastroRepository.deleteById(id);
    }

    public Cadastro editarCadastro(Long id, Cadastro cadastroAtualizado) {
        Cadastro cadastroExistente = cadastroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cadastro inexistente"));
        cadastroExistente.setNome(cadastroAtualizado.getNome());
        cadastroExistente.setCpf(cadastroAtualizado.getCpf());

        return cadastroRepository.save(cadastroExistente);
    }
}
