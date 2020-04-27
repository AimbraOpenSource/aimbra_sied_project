package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.interfaces.AlunoBuilder;
import com.aimbra.sied.builders.interfaces.UserBuilder;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;

import java.util.List;

public class AlunoBuilderImpl implements AlunoBuilder {

    private AlunoDto alunoDto;

    public AlunoBuilderImpl() {
        alunoDto = new AlunoDto();
        alunoDto.setNome("Thiago dos Santos Celestino da Cunha");
        alunoDto.setUser(getUser().build());
        alunoDto.setTurmas(getTurmas());
    }

    private List<TurmaDto> getTurmas() {
        return List.of(
                new TurmaBuilderImpl().build(),
                new TurmaBuilderImpl().build(),
                new TurmaBuilderImpl().build()
        );
    }

    private UserBuilder getUser() {
        return new UserBuilderImpl(UserRole.ALUNO);
    }

    @Override
    public AlunoDto build() {
        return alunoDto;
    }

    @Override
    public AlunoBuilder withIdNull() {
        alunoDto.setId(null);
        return this;
    }

    @Override
    public AlunoBuilder withUserNull() {
        alunoDto.setUser(null);
        return this;
    }

    @Override
    public AlunoBuilder withTurmasNull() {
        alunoDto.setTurmas(null);
        return this;
    }

    @Override
    public AlunoBuilder withTurmas(List<TurmaDto> turmas) {
        if (turmas == null || turmas.isEmpty()) {
            alunoDto.setTurmas(turmas);
        }
        return this;
    }

}
