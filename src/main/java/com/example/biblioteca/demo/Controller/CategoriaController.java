package com.example.biblioteca.demo.Controller;


import com.example.biblioteca.demo.Service.CategoriaService;
import com.example.biblioteca.demo.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> ListarCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria editar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return  categoriaService.editarCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        categoriaService.excluirCategoria(id);
        return "Excluido com sucesso";
    }
}
