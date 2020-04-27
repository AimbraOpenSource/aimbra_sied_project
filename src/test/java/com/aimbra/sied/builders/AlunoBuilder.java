package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.security.sied.enums.UserRole;

import java.util.List;

public class AlunoBuilder {

    private AlunoDto alunoDto;

    private AlunoBuilder() {
    }

    public static AlunoBuilder init() {
        AlunoBuilder ab = new AlunoBuilder();
        ab.alunoDto = new AlunoDto();
        ab.alunoDto.setNome("Thiago dos Santos Celestino da Cunha");
        ab.alunoDto.setUser(UserBuilder.init(UserRole.ALUNO).build());
        ab.alunoDto.setTurmas(
            List.of(
                TurmaBuilder.init().build(),
                TurmaBuilder.init().build(),
                TurmaBuilder.init().build()
            )
        );
        return ab;
    }

    public AlunoDto build() {
        return alunoDto;
    }

    public AlunoBuilder withIdNull() {
        alunoDto.setId(null);
        return this;
    }

    public AlunoBuilder withUserNull() {
        alunoDto.setUser(null);
        return this;
    }

    public AlunoBuilder withTurmasNull() {
        alunoDto.setTurmas(null);
        return this;
    }

    public AlunoBuilder withTurmas(List<TurmaDto> turmas) {
        if (turmas == null || turmas.isEmpty()) {
            alunoDto.setTurmas(turmas);
        }
        return this;
    }

    public AlunoBuilder fromId(Integer id) {
        alunoDto.setId(id);
        return this;
    }

}
