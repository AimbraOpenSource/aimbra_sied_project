package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;

public class ProfessorBuilder {

    private ProfessorDto professorDto;

    public ProfessorBuilder() {
        professorDto = new ProfessorDto();
        professorDto.setId(1);
        professorDto.setNome("Alan Galante");
        professorDto.setUser(getUser());
    }

    private UserDto getUser() {
        return UserBuilder.init(UserRole.PROFESSOR).build();
    }

    public ProfessorDto build() {
        return professorDto;
    }

    public ProfessorBuilder withIdNull() {
        professorDto.setId(null);
        return this;
    }

    public ProfessorBuilder withUserNull() {
        professorDto.setUser(null);
        return this;
    }

    public ProfessorBuilder withNomeNull() {
        professorDto.setNome(null);
        return this;
    }
}
