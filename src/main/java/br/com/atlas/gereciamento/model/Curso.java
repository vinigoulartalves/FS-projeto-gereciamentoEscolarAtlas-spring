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

    public static Curso inserir(Curso curso) {
        curso.id = proximoId++;
        cursosCadastrados.add(curso);
        return curso;
    }
}
