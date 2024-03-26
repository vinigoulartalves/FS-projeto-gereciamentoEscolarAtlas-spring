package br.com.atlas.gereciamento.service;

import br.com.atlas.gereciamento.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

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


}
