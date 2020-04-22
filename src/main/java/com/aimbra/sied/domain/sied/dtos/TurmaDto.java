package com.aimbra.sied.domain.sied.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class TurmaDto {
    private Integer id;
    private String uuid;
    private String senha;
    private CursoDto curso;
    private ProfessorDto professor;
    private List<AlunoDto> alunos = new ArrayList<>();

    public void addAluno(AlunoDto aluno) {
        alunos.add(aluno);
        aluno.getTurmas().add(this);
    }

    public void removealuno(AlunoDto aluno) {
        alunos.remove(aluno);
        aluno.getTurmas().remove(this);
    }

}
