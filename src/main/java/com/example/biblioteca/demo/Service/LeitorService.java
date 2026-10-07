package com.example.biblioteca.demo.Service;

import com.example.biblioteca.demo.Repository.LeitorRepository;
import com.example.biblioteca.demo.Repository.LivroRepository;
import com.example.biblioteca.demo.model.Leitor;
import com.example.biblioteca.demo.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitorService {
    private final LeitorRepository leitorRepository;

    public LeitorService(LeitorRepository leitorRepository) {
        this.leitorRepository = leitorRepository;
    }

    public List<Leitor> listarLeitores() {
        return leitorRepository.findAll();
    }

    public Leitor salvarLeitor(Leitor leitor) {
        return leitorRepository.save(leitor);
    }

    public void excluirLeitor(Long id) {
        if (!leitorRepository.existsById(id)) {
            throw new RuntimeException("Não é possível excluir");
        }
        leitorRepository.deleteById(id);
    }

    public Leitor editarLeitor(Long id, Leitor leitorAtualizado) {
        Leitor leitorExistente = leitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leitor inexistente"));

        leitorExistente.setNome(leitorAtualizado.getNome());
        leitorExistente.setEmail(leitorAtualizado.getEmail());
        leitorExistente.setLivros(leitorAtualizado.getLivros());

        if (leitorExistente.getCadastro() != null && leitorAtualizado.getCadastro() != null) {
            leitorExistente.getCadastro().setNome(leitorAtualizado.getCadastro().getNome());
            leitorExistente.getCadastro().setCpf(leitorAtualizado.getCadastro().getCpf());
        }

        return leitorRepository.save(leitorExistente);
    }
}
