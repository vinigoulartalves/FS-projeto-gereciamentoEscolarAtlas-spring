package br.com.atlas.gereciamento.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Aluno {

    @Getter
    private static final List<Aluno> alunosMatriculados = new ArrayList<>();

    private static Integer proximoId = 1;
    private Integer id;
    @Setter
    private String nome;
    @Setter
    private String dataNascimento;

    public static Aluno inserir(Aluno aluno) {
        aluno.id = proximoId++;
        alunosMatriculados.add(aluno);
        return aluno;
    }

    public static Aluno buscarPorId(Integer id) throws Exception {
        for (Aluno aluno : alunosMatriculados) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado.");
    }
}


