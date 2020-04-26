package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.InscricaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InscricaoValidator {

    @Autowired
    private TextValidator textValidator;

    private void turmaIsInvalid(TurmaDto turma) {
        if (turma == null) {
            throw new BadRequestException("Turma esta nulo");
        }
    }

    private void alunoIsInvalid(AlunoDto aluno) {
        if (aluno == null) {
            throw new BadRequestException("Aluno esta nulo");
        }
    }

    public void cannotCreate(InscricaoDto inscricaoDto) {
        alunoIsInvalid(inscricaoDto.getAluno());
        turmaIsInvalid(inscricaoDto.getTurma());
    }

}
