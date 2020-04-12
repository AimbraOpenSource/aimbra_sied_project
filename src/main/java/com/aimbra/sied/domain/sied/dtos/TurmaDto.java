package com.aimbra.sied.domain.sied.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class TurmaDto {
    private Integer id;
    private String uuid;
    private String senha;
    private CursoDto curso;
    private List<AlunoDto> alunos = new ArrayList<>();
    private ProfessorDto professor;
}
