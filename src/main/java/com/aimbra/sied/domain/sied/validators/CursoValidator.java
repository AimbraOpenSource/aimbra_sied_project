package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.dtos.CursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CursoValidator {
    @Qualifier("textValidatorImpl")
    @Autowired
    private TextValidator textValidator;

    private void nomeIsInvalid(String nome) {
        textValidator
                .whereValueIs(nome)
                .whereMessageErrorIs("Nome esta nulo ou vázio")
                .isNullOrEmpty()
                .whereRangeLengthIs(3, 64)
                .whereMessageErrorIs("O curso precisa ter entre 3 a 64 caracteres")
                .hasInvalidLength()
                .isValid();
    }

    public void cannotCreate(CursoDto dto) {
        nomeIsInvalid(dto.getNome());
    }
}
