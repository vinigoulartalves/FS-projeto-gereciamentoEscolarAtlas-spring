package br.com.atlas.gereciamento.service;

import br.com.atlas.gereciamento.model.Aluno;
import br.com.atlas.gereciamento.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //Cadastro de cursos
    public Curso salvar(Curso curso) throws Exception {
        if (validar(curso)) {
            return Curso.inserir(curso);
        }
        return null;
    }

    private boolean validar(Curso curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome obrigatório!");
        }

        if (curso.getDescricao() == null || curso.getDescricao().isBlank()) {
            throw new Exception("Data de nascimento obrigatória");
        }

        return true;
    }

    //Mostra os todos os alunos
    public List<Curso> buscarTodos() {
        return Curso.getCursosCadastrados();
    }

    public Curso buscarId(Integer id) throws Exception {
        return Curso.buscarPorId(id);
    }

    //Cadastra o aluno no curso por id
    public Curso adicionarAluno(Integer id, Integer alunoId) throws Exception {
        Curso curso = buscarId(id);
        Aluno aluno = alunoService.buscarId(alunoId);
        Curso.adicionarAluno(curso, aluno);
        return curso;
    }


}
