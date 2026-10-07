package com.example.biblioteca.demo.Controller;


import com.example.biblioteca.demo.Service.LeitorService;
import com.example.biblioteca.demo.model.Leitor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leitores")
public class LeitorController {

    private final LeitorService leitorService;

    public LeitorController(LeitorService leitorService) {
        this.leitorService = leitorService;
    }

    @GetMapping
    public List<Leitor> listarLeitor() {
        return leitorService.listarLeitores();
    }

    @PostMapping
    public Leitor salvar(@RequestBody Leitor leitor) {
        return leitorService.salvarLeitor(leitor);
    }

    @PutMapping("/{id}")
    public Leitor editar(@PathVariable Long id, @RequestBody Leitor leitor) {
        return  leitorService.editarLeitor(id, leitor);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        leitorService.excluirLeitor(id);
        return "Excluido com sucesso";
    }
}
