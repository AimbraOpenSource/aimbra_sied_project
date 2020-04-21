package com.aimbra.sied.domain.sied.dtos;

import lombok.Data;

@Data
public class AlunoOfProfessorDto {
    Integer id;
    String nome;
    Integer cursoId;
    String curso;
    Integer professorId;
    String professor;
}
