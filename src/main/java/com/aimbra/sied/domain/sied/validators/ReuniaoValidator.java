package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReuniaoValidator {

    @Qualifier("textValidatorImpl")
    @Autowired
    private TextValidator textValidator;

    private void topicoIsInvalid(String topico) {
        textValidator
                .whereValueIs(topico)
                .whereMessageErrorIs("O tópico da reunião esta nula ou vazio")
                .isNullOrEmpty()
                .whereRangeLengthIs(10, 64)
                .whereMessageErrorIs("O tópico da reunião precisa ter entre 10 a 64 cracteres")
                .hasInvalidLength()
                .isValid();
    }

    private void descricaoIsInvalid(String descricao) {
        textValidator
                .whereValueIs(descricao)
                .whereMessageErrorIs("A descrição da reunião esta nula ou vazio")
                .isNullOrEmpty()
                .whereRangeLengthIs(50, 10000)
                .whereMessageErrorIs("A descrição da reunião precisa ter entre 10 a 10000 cracteres")
                .hasInvalidLength()
                .isValid();
    }

    private void linkIsInvalid(String link) {
        textValidator
                .whereValueIs(link)
                .whereMessageErrorIs("O link da reunião esta nula ou vazia")
                .isNullOrEmpty()
                .whereRangeLengthIs(10, 255)
                .whereMessageErrorIs("O link da reunião precisa ter entre 10 a 64 cracteres")
                .hasInvalidLength()
                .isValid();
    }

    private void duracaoIsInvalid(String duracao) {
        textValidator
                .whereValueIs(duracao)
                .whereMessageErrorIs("A duração da reunião esta nula ou vazio")
                .isNullOrEmpty()
                .whereRangeLengthIs(1, 3)
                .whereMessageErrorIs("A duração da reunião precisa ter entre 1 a 3 cracteres")
                .hasInvalidLength()
                .isValid();
    }

    private void dataHoraInicioIsInvalid(LocalDateTime dataHoraInicio) {
        if (dataHoraInicio == null) {
            throw new BadRequestException("Data e Hora do inicio da reunião esta nula");
        }
        // TODO Verificar se o professor já possui uma reunião marcada para este dia/hora
    }

    private void fusoHorarioIsInvalid(String fusoHorario) {
        textValidator
                .whereValueIs(fusoHorario)
                .whereMessageErrorIs("Fuso horário da reunião esta nulo ou vazio")
                .isNullOrEmpty()
                .whereRangeLengthIs(5, 32)
                .whereMessageErrorIs("Fuso horario da reunião precisa ter entre 5 a 32 caracteres")
                .hasInvalidLength()
                .isValid();
    }

    private void senhaIsInvalid(String senha) {
        if (senha != null && !senha.isEmpty()) {
            textValidator
                    .whereValueIs(senha)
                    .whereMessageErrorIs("A senha da reunião precisa ter entre 6 a 16 caracteres")
                    .hasInvalidLength()
                    .isValid();
        }
    }

    private void videoAnfitriaoAtivadoIsInvalid(Boolean value) {
        if (value == null) {
            throw new BadRequestException("Video anitrião esta nulo");
        }
    }

    private void videoParticipanteAtivadoIsInvalid(Boolean value) {
        if (value == null) {
            throw new BadRequestException("Video participante esta nulo");
        }
    }

    private void foiRealizadaIsInvalid(Boolean value) {
        if (value == null) {
            throw new BadRequestException("O campo foi realizado esta nulo");
        }
    }

    public void cannotCreate(ReuniaoDto dto) {
        topicoIsInvalid(dto.getTopico());
        descricaoIsInvalid(dto.getDescricao());
        linkIsInvalid(dto.getLink());
        duracaoIsInvalid(dto.getDuracao());
        dataHoraInicioIsInvalid(dto.getDataHoraInicio());
        fusoHorarioIsInvalid(dto.getFusoHorario());
        senhaIsInvalid(dto.getSenha());
        videoAnfitriaoAtivadoIsInvalid(dto.getVideoAnfitriaoAtivado());
        videoParticipanteAtivadoIsInvalid(dto.getVideoParticipanteAtivado());
        foiRealizadaIsInvalid(dto.getFoiRealizada());
    }

}
