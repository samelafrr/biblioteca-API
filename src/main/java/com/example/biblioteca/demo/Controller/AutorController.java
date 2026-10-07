package com.example.biblioteca.demo.Controller;

import com.example.biblioteca.demo.Service.AutorService;
import com.example.biblioteca.demo.model.Autor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> ListarAutores() {
        return autorService.listarAutores();
    }

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        return autorService.salvarAutor(autor);
    }

    @PutMapping("/{id}")
    public Autor editar(@PathVariable Long id, @RequestBody Autor autor) {
        return  autorService.editarAutor(id, autor);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        autorService.excluirAutor(id);
        return "Excluido com sucesso";
    }
}
