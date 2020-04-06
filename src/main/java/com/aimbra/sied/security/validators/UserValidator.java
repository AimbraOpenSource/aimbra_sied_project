package com.aimbra.sied.security.validators;

import com.aimbra.sied.business.apis.impls.TextValidatorImpl;
import com.aimbra.sied.business.services.UserService;
import com.aimbra.sied.domain.utils.RegexUtils;
import com.aimbra.sied.exceptions.BadRequestException;
import com.aimbra.sied.security.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private UserService userService;

    private void existsUserByUsername(String username) {
        if (userService.existsUserByUsername(username)) {
            throw new BadRequestException("Já existe um apelido registrado com este nome");
        }
    }

    private void existsUserByEmail(String email) {
        if (userService.existsUserByEmail(email)) {
            throw new BadRequestException("Já existe um email registrado na base de dados.");
        }
    }

    public void cannotRegister(UserDto dto) {
        TextValidatorImpl.init()
                .whereValueIs(dto.getUsername())
                .whereMessageErrorIs("Username esta vazio ou nulo")
                .isNull()
                .isEmpty()
                .whereRangeLengthIs(6, 16)
                .whereMessageErrorIs("Apelido precisa ter entre 6 a 16 caracteres")
                .hasInvalidLength()
                .isValid();

        TextValidatorImpl.init()
                .whereValueIs(dto.getUsername())
                .whereMessageErrorIs("A senha esta vazio ou nula")
                .isNull()
                .isEmpty()
                .whereRangeLengthIs(6, 16)
                .whereMessageErrorIs("A senha precisa ter entre 6 a 16 caracteres")
                .hasInvalidLength()
                .isValid();

        TextValidatorImpl.init()
                .whereValueIs(dto.getEmail())
                .whereMessageErrorIs("A Email esta vazio ou nulo")
                .isNull()
                .isEmpty()
                .whereRangeLengthIs(6, 128)
                .whereMessageErrorIs("O email precisa ter entre 8 a 128 caracteres")
                .hasInvalidLength()
                .whereMessageErrorIs("Dominio inválido para este email.")
                .testRegex(RegexUtils.isValidDomainEmail(dto.getEmail(), null))
                .isValid();

        if (dto.getRole() == null) {
            throw new BadRequestException("Erro no servidor ao tentar apontar o Role de Usuário. Contacte um Suporte do Sistema");
        }

        existsUserByUsername(dto.getUsername());
        existsUserByEmail(dto.getEmail());
    }
}
