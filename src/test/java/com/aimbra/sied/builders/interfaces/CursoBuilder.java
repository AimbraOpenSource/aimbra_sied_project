package com.aimbra.sied.builders.interfaces;

import com.aimbra.sied.domain.sied.dtos.CursoDto;

public interface CursoBuilder {
    CursoDto build();
    CursoBuilder withIdNull();
    CursoBuilder withNomeNull();
}
