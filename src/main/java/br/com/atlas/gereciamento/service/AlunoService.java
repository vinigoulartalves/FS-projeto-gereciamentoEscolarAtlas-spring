package br.com.atlas.gereciamento.service;


import br.com.atlas.gereciamento.model.Aluno;
import br.com.atlas.gereciamento.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    //Cadastro de alunos
    public Aluno salvar(Aluno aluno) throws Exception {
        if (validar(aluno)) {
            return Aluno.inserir(aluno);
        }
        return null;
    }

    private boolean validar(Aluno aluno) throws Exception {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new Exception("Nome obrigatório!");
        }

        if (aluno.getDataNascimento() == null || aluno.getDataNascimento().isBlank()) {
            throw new Exception("Data de nascimento obrigatória");
        }

        return true;
    }

    //Mostra os todos os alunos
    public List<Aluno> buscarTodos() {
        return Aluno.getAlunosMatriculados();
    }

    public Aluno buscarId(Integer id) throws Exception {
        return Aluno.buscarPorId(id);
    }
}
