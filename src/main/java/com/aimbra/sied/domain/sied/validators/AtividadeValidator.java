package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.business.sied.apis.impls.TextValidatorImpl;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AtividadeValidator {

    @Qualifier("textValidatorImpl")
    @Autowired
    private TextValidator textValidator;

    @Autowired
    private AulaValidator aulaValidator;

    private void tituloIsInvalid(String titulo) {
        textValidator
                .whereValueIs(titulo)
                .whereMessageErrorIs("Titulo esta nulo ou vazio")
                .isNullOrEmpty()
                .whereRangeLengthIs(10, 255)
                .whereMessageErrorIs("O titulo deve ter entre 10 a 255 caracteres")
                .hasInvalidLength()
                .isValid();
    }

    private void descricaoIsInvalid(String descricao) {
        textValidator
                .whereValueIs(descricao)
                .whereMessageErrorIs("A descrição esta nula ou vazia")
                .isNullOrEmpty()
                .whereRangeLengthIs(40, 10000)
                .whereMessageErrorIs("A descrição precisa ter entre 40 a 10000 caracteres")
                .hasInvalidLength()
                .isValid();
    }

    public void cannotCreate(AtividadeDto dto) {
        tituloIsInvalid(dto.getTitulo());
        descricaoIsInvalid(dto.getDescricao());
        aulaValidator.cannotCreate(dto.getAula());
    }
}
