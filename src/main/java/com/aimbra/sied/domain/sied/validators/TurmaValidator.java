package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.business.sied.converters.ProfessorConverter;
import com.aimbra.sied.domain.sied.dtos.CursoDto;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TurmaValidator {

    @Qualifier("textValidatorImpl")
    @Autowired
    private TextValidator textValidator;

    @Autowired
    private CursoValidator cursoValidator;

    @Autowired
    private ProfessorValidator professorValidator;

    private void senhaIsInvalid(String senha) {
        textValidator
            .whereValueIs(senha)
            .whereMessageErrorIs("A Senha esta nula ou vazia")
            .isNullOrEmpty()
            .whereFixedLentghIs(6)
            .whereMessageErrorIs("A senha precisa ter 6 caracteres")
            .sizeIsIqualsTo()
            .isValid();
    }

    private void cursoIsInvalid(CursoDto curso) {
        if (curso == null) {
            throw new BadRequestException("Curso esta nulo");
        }
        cursoValidator.cannotCreate(curso);
    }

    private void professorIsInvalid(ProfessorDto dto) {
        if (dto == null) {
            throw new BadRequestException("Professor esta nulo");
        }
        professorValidator.cannotCreate(dto);
    }

    public void cannotCreate(TurmaDto dto) {
        senhaIsInvalid(dto.getSenha());
        cursoIsInvalid(dto.getCurso());
        professorIsInvalid(dto.getProfessor());
    }
}
