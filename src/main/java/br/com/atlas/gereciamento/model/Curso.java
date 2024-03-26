package br.com.atlas.gereciamento.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Curso {

    @Getter
    private static List<Curso> cursosCadastrados = new ArrayList<>();

    private static Integer proximoId = 1;
    private Integer id;
    @Setter
    private String nome;
    @Setter
    private String descricao;
    @Setter
    private Integer cargaHoraria;

    private List<Aluno> alunos = new ArrayList<>();

    public static Curso inserir(Curso curso) {
        curso.id = proximoId++;
        cursosCadastrados.add(curso);
        return curso;
    }

    public static Curso buscarPorId(Integer id) throws Exception {
        for (Curso curso : cursosCadastrados) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado.");
    }

    public static void adicionarAluno(Curso curso, Aluno aluno) {
        curso.getAlunos().add(aluno);
    }


}
