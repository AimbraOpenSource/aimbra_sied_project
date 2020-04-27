package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.CursoBuilder;
import com.aimbra.sied.domain.sied.dtos.CursoDto;

public class CursoBuilderImpl implements CursoBuilder {

    private CursoDto cursoDto;

    public CursoBuilderImpl() {
        cursoDto = new CursoDto();
        cursoDto.setNome("Matemática");
        cursoDto.setId(1);
    }

    @Override
    public CursoDto build() {
        return cursoDto;
    }

    @Override
    public CursoBuilder withIdNull() {
        cursoDto.setId(null);
        return this;
    }

    @Override
    public CursoBuilder withNomeNull() {
        cursoDto.setNome(null);
        return this;
    }
}
