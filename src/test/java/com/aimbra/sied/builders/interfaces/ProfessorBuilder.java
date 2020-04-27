package com.aimbra.sied.builders.interfaces;

import com.aimbra.sied.domain.sied.dtos.ProfessorDto;

public interface ProfessorBuilder {
    ProfessorDto build();
    ProfessorBuilder withIdNull();
    ProfessorBuilder withUserNull();
    ProfessorBuilder withNomeNull();
}
