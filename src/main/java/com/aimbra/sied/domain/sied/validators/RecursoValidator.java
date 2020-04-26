package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecursoValidator {

    @Autowired
    private TextValidator textValidator;

    public void cannotFindById(Integer id) {
        if (id == null) {
            throw new BadRequestException("Id esta nulo");
        }
    }

}
