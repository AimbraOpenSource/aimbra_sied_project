package com.aimbra.sied.security.validators;

import com.aimbra.sied.business.apis.impls.TextValidatorImpl;
import com.aimbra.sied.business.services.UserService;
import com.aimbra.sied.exceptions.BadRequestException;
import com.aimbra.sied.security.dtos.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private UserService userService;

    public void existsUserByUsername(String username) {
        if (userService.existsUserByUsername(username)) {
            throw new BadRequestException("Já existe um apelido registrado com este nome");
        }
    }

    public void cannotRegister(UserRegisterDto dto) {
//        TextValidatorImpl.init()
//                .whereValueIs(dto.getUsername())
//                .whereMessageErrorIs("Username esta vazio ou nulo")
//                .isNull()
//                .isEmpty()
//                .whereRangeLengthIs(6, 16)
//                .whereMessageErrorIs("Apelido precisa ter entre 6 a 16 caracteres")
//                .hasInvalidLength()
//                .isValid();
//
//        TextValidatorImpl.init()
//                .whereValueIs(dto.getUsername())
//                .whereMessageErrorIs("A senha esta vazio ou nula")
//                .isNull()
//                .isEmpty()
//                .whereRangeLengthIs(6, 16)
//                .whereMessageErrorIs("A senha precisa ter entre 6 a 16 caracteres")
//                .hasInvalidLength()
//                .isValid();
//
//        existsUserByUsername(dto.getUsername());
    }
}
