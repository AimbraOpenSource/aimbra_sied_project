package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.CursoDto;

public class CursoBuilder {

    private CursoDto cursoDto;

    public CursoBuilder() {
        cursoDto = new CursoDto();
        cursoDto.setNome("Matemática");
        cursoDto.setId(1);
    }

    public CursoDto build() {
        return cursoDto;
    }

    public CursoBuilder withIdNull() {
        cursoDto.setId(null);
        return this;
    }

    public CursoBuilder withNomeNull() {
        cursoDto.setNome(null);
        return this;
    }
}
