package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProfessorValidator {

    @Qualifier("textValidatorImpl")
    @Autowired
    private TextValidator textValidator;

    @Autowired
    private UserValidator userValidator;

    private void userIsInvalid(UserDto user) {
        if (user == null) {
            throw new BadRequestException("Usuário esta nulo ou vazio");
        }
        userValidator.cannotRegister(user);
    }

    private void nomeIsInvalid(String nome) {
        textValidator
                .whereValueIs(nome)
                .whereMessageErrorIs("Nome do professor esta nulo ou vazio")
                .isNullOrEmpty()
                .whereRangeLengthIs(5, 64)
                .whereMessageErrorIs("O nome do professor precisa ter entre 5 a 64 caracteres")
                .hasInvalidLength()
                .isValid();
    }

    public void cannotCreate(ProfessorDto professor) {
        nomeIsInvalid(professor.getNome());
        userIsInvalid(professor.getUser());
    }
}
