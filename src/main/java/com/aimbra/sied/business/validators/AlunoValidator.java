package com.aimbra.sied.business.validators;

import com.aimbra.sied.business.apis.impls.TextValidatorImpl;
import com.aimbra.sied.domain.dtos.AlunoDto;
import com.aimbra.sied.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class AlunoValidator {

    public void cannotCreate(AlunoDto dto) {
        TextValidatorImpl.init()
                .whereValueIs(dto.getNome())
                .whereMessageErrorIs("Nome do aluno esta nulo ou vazio")
                .isNull()
                .isEmpty()
                .whereRangeLengthIs(8, 128)
                .whereMessageErrorIs("O aluno precisa ter entre 8 a 128 caracteres")
                .hasInvalidLength()
                .isValid();

        if (dto.getUser() == null) {
            throw new BadRequestException("Usuário esta nulo");
        }
    }

}
