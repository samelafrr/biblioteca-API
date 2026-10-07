package com.example.biblioteca.demo.Controller;

import com.example.biblioteca.demo.Service.CadastroService;
import com.example.biblioteca.demo.model.Cadastro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @GetMapping
    public List<Cadastro> listarCadastros() {
        return cadastroService.listarCadastros();
    }

    @PostMapping
    public Cadastro salvar(@RequestBody Cadastro cadastro) {
        return cadastroService.salvarCadastro(cadastro);
    }

    @PutMapping("/{id}")
    public Cadastro editar(@PathVariable Long id, @RequestBody Cadastro cadastro) {
        return cadastroService.editarCadastro(id, cadastro);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        cadastroService.excluirCadastro(id);
        return "Excluido com sucesso";
    }
}