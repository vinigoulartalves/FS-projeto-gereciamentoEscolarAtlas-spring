package br.com.atlas.gereciamento.controller;

import br.com.atlas.gereciamento.model.Aluno;
import br.com.atlas.gereciamento.model.Curso;
import br.com.atlas.gereciamento.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    public final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    //Cadastro de cursos
    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.salvar(curso);
    }

    //Buscar todos cursos
    @GetMapping
    public List<Curso> get() {
        return cursoService.buscarTodos();
    }

    //Cadastro de aluno na turma
    @PostMapping("{id}/add-aluno")
    public Curso postAluno(@PathVariable Integer id, @RequestBody Aluno aluno) throws Exception {
        return cursoService.adicionarAluno(id, aluno.getId());
    }

}
