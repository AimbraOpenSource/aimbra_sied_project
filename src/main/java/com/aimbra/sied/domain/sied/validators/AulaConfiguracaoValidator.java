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
        fielIsInvalid(dto.isTemAgendamento(), "O campo tem agendamento esta nulo");
        fielIsInvalid(dto.isAlunoFazUpload(), "O campo aluno faz upload esta nulo");
        fielIsInvalid(dto.isRespostaTemTexto(), "O campo tem resposta em texto esta nulo");
        fielIsInvalid(dto.isTemAulaAoVivo(), "O campo tem aula ao vivo esta nulo");
        fielIsInvalid(dto.isTemDiscusao(), "O campo tem discussão esta nulo");
    }
}
