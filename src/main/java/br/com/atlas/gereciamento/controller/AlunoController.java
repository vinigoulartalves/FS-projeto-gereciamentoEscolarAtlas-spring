package br.com.atlas.gereciamento.controller;


import br.com.atlas.gereciamento.model.Aluno;
import br.com.atlas.gereciamento.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    public final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //Cadastro de alunos
    @PostMapping
    public Aluno post(@RequestBody Aluno aluno) throws Exception {
        return alunoService.salvar(aluno);
    }

    //Buscar todos alunos
    @GetMapping
    public List<Aluno> get() {
        return alunoService.buscarTodos();
    }
}
