package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.security.sied.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoValidator {

    @Autowired
    private TextValidator textValidator;

    @Autowired
    private UserValidator userValidator;

    private void nomeIsInvlaid(String nome) {
        textValidator
                .whereValueIs(nome)
                .whereMessageErrorIs("Nome esta nulo ou vazio")
                .isNullOrEmpty()
                .whereRangeLengthIs(10, 128)
                .whereMessageErrorIs("O nome precisa ter entre 10 a 128 caracteres")
                .hasInvalidLength()
                .isValid();
    }

    private void userIsInvlaid(UserDto user) {
        if (user == null) {
            throw new BadRequestException("Usuário esta nulo ou vazio");
        }
        userValidator.cannotRegister(user);
    }

    public void cannotRegister(AlunoDto dto) {
        nomeIsInvlaid(dto.getNome());
        userIsInvlaid(dto.getUser());
    }



}
