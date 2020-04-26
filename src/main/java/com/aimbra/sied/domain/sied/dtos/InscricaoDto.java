package com.aimbra.sied.domain.sied.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InscricaoDto {
    private TurmaDto turma;
    private AlunoDto aluno;

    public void addAlunoInTurma(AlunoDto aluno) {
        this.getTurma().addAluno(aluno);
    }

}
