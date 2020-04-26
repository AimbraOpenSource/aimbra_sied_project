package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AulaValidator {

    @Qualifier("textValidatorImpl")
    @Autowired
    private TextValidator textValidator;

    @Autowired
    private TurmaValidator turmaValidator;

    @Autowired
    private ReuniaoValidator reuniaoValidator;

    @Autowired
    private AulaConfiguracaoValidator aulaConfiguracaoValidator;


    private void tituloIsInvalid(String titulo) {
        textValidator
            .whereValueIs(titulo)
            .whereMessageErrorIs("Titulo esta nulo ou vazio")
            .isNullOrEmpty()
            .whereRangeLengthIs(10, 128)
            .whereMessageErrorIs("O titulo deve ter entre 10 a 128 caracteres")
            .hasInvalidLength()
            .isValid();
    }

    private void descricaoIsInvalid(String descricao) {
        textValidator
            .whereValueIs(descricao)
            .whereMessageErrorIs("A URL do vídeo gravado esta nula ou vazia")
            .isNullOrEmpty()
            .whereRangeLengthIs(5, 1024)
            .whereMessageErrorIs("A Url do vídeo gravado deve ter entre 5 a 1024 caracteres")
            .hasInvalidLength()
            .isValid();
    }

    private void urlIsInvalid(String url) {
        textValidator
            .whereValueIs(url)
            .whereMessageErrorIs("A descrição esta nula ou vazia")
            .isNullOrEmpty()
            .whereRangeLengthIs(50, 10000)
            .whereMessageErrorIs("A descrição precisa ter entre 50 a 10000 cracteres")
            .hasInvalidLength()
            .isValid();
    }

    private void observacaoIsInvalid(String observacao) {
        if (observacao != null && observacao.isEmpty()) {
            textValidator
                .whereValueIs(observacao)
                .whereMessageErrorIs("A descrição esta nula ou vazia")
                .isNullOrEmpty()
                .whereRangeLengthIs(50, 10000)
                .whereMessageErrorIs("A descrição precisa ter entre 50 a 10000 cracteres")
                .hasInvalidLength()
                .isValid();
        }
    }

    private void turmaIsInvalid(TurmaDto turmaDto) {
        if (turmaDto == null) {
            throw new BadRequestException("Turma esta nulo ou vazia");
        }
        turmaValidator.cannotCreate(turmaDto);
    }

    private void reuniaoIsInvalid(ReuniaoDto reuniaoDto) {
        if (reuniaoDto == null) {
            throw new BadRequestException("Reunião esta nulo ou vazia");
        }
        reuniaoValidator.cannotCreate(reuniaoDto);
    }

    private void aulaConfiguracaoIsInvalid(AulaConfiguracaoDto aulaConfiguracaoDto) {
        if (aulaConfiguracaoDto == null) {
            throw new BadRequestException("A configuração esta nula ou vazia");
        }
        aulaConfiguracaoValidator.cannotCreate(aulaConfiguracaoDto);
    }

    public void cannotCreate(AulaDto dto) {
        tituloIsInvalid(dto.getTitulo());
        descricaoIsInvalid(dto.getDescricao());
        urlIsInvalid(dto.getUrlVideoGravado());
        observacaoIsInvalid(dto.getObservacao());
        turmaIsInvalid(dto.getTurma());
        reuniaoIsInvalid(dto.getReuniao());
        aulaConfiguracaoIsInvalid(dto.getConfiguracao());
    }

    public void cannotFind(Integer valueId) {
        if (valueId == null) {
            throw new BadRequestException("O Id esta nulo");
        }
    }
}
