package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class AulaConfiguracaoValidator {

    private void fielIsInvalid(
            Boolean value,
            String messageError
    ) {
        if (value == null) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }

    public void cannotCreate(AulaConfiguracaoDto dto) {
        fielIsInvalid(dto.getTemAgendamento(), "O campo tem agendamento esta nulo");
        fielIsInvalid(dto.getAlunoFazUpload(), "O campo aluno faz upload esta nulo");
        fielIsInvalid(dto.getRespostaTemTexto(), "O campo tem resposta em texto esta nulo");
        fielIsInvalid(dto.getTemAulaAoVivo(), "O campo tem aula ao vivo esta nulo");
        fielIsInvalid(dto.getTemDiscusao(), "O campo tem discussão esta nulo");
    }
}
