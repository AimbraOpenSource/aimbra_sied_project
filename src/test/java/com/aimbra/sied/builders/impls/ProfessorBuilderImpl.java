package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.ProfessorBuilder;
import com.aimbra.sied.builders.UserBuilder;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.security.sied.enums.UserRole;

public class ProfessorBuilderImpl implements ProfessorBuilder {

    private ProfessorDto professorDto;

    public ProfessorBuilderImpl() {
        professorDto = new ProfessorDto();
        professorDto.setId(1);
        professorDto.setNome("Alan Galante");
        professorDto.setUser(getUser().build());
    }

    private UserBuilder getUser() {
        return new UserBuilderImpl(UserRole.PROFESSOR);
    }

    @Override
    public ProfessorDto build() {
        return professorDto;
    }

    @Override
    public ProfessorBuilder withIdNull() {
        professorDto.setId(null);
        return this;
    }

    @Override
    public ProfessorBuilder withUserNull() {
        professorDto.setUser(null);
        return this;
    }

    @Override
    public ProfessorBuilder withNomeNull() {
        professorDto.setNome(null);
        return this;
    }
}
