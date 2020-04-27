package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.TurmaDto;

public interface TurmaBuilder {
    TurmaDto build();
    TurmaBuilder withIdNull();
    TurmaBuilder withUuidNull();
    TurmaBuilder withsenhaNull();
    TurmaBuilder withCursoNull();
    TurmaBuilder withProfessorNull();
    TurmaBuilder withAlunosNull();
    TurmaBuilder withAlunosEmpty();
}
