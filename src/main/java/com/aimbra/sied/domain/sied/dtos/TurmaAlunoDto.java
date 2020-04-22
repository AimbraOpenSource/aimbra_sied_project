package com.aimbra.sied.domain.sied.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class TurmaAlunoDto {
    private Integer id;
    private String uuid;
    private String senha;
    private CursoDto curso;
    private ProfessorDto professor;
    private List<AlunoDto> alunos = new ArrayList<>();

    @JsonIgnore
    @JsonProperty(value = "alunos")
    public List<AlunoDto> getAlunos() {
        return alunos;
    }
}
