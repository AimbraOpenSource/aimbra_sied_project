package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.interfaces.RecursoBuilder;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;

import java.time.LocalDateTime;

public class RecursoBuilderImpl implements RecursoBuilder {

    RecursoDto recursoDto;

    public RecursoBuilderImpl() {
        recursoDto = new RecursoDto();
        recursoDto.setId(1);
        recursoDto.setNomeReal("Aqui vai o nome Real");
        recursoDto.setNomeLogico("Aqui vai o nome Lógico");
        recursoDto.setCaminho("Aqui vai o caminho da parada");
        recursoDto.setTipo(TipoRecurso.EXERCICIO_PROPOSTO);
        recursoDto.setCriadoEm(LocalDateTime.now());
        recursoDto.setAtualizadoEm(LocalDateTime.now());
        recursoDto.setUser(getProfessorUser());
        recursoDto.setAula(getAula());
    }

    private AulaDto getAula() {
        return new AulaBuilderImpl().build();
    }

    private UserDto getProfessorUser() {
        return new UserBuilderImpl(UserRole.PROFESSOR).build();
    }

    private UserDto getAlunoUser() {
        return new UserBuilderImpl(UserRole.ALUNO).build();
    }

    @Override
    public RecursoDto build() {
        return recursoDto;
    }

    @Override
    public RecursoBuilder withIdNull() {
        recursoDto.setId(null);
        return this;
    }

    @Override
    public RecursoBuilder withNomeRealNull() {
        recursoDto.setNomeReal(null);
        return this;
    }

    @Override
    public RecursoBuilder withNomeLogicoNull() {
        recursoDto.setNomeLogico(null);
        return this;
    }

    @Override
    public RecursoBuilder withCaminhoNull() {
        recursoDto.setCaminho(null);
        return this;
    }

    @Override
    public RecursoBuilder withTipoNull() {
        recursoDto.setTipo(null);
        return this;
    }

    @Override
    public RecursoBuilder withUserNull() {
        recursoDto.setUser(null);
        return this;
    }

    @Override
    public RecursoBuilder withCriadoEmNull() {
        recursoDto.setCriadoEm(null);
        return this;
    }

    @Override
    public RecursoBuilder withAtualizadoEmNull() {
        recursoDto.setAtualizadoEm(null);
        return this;
    }

    @Override
    public RecursoBuilder withAulaNull() {
        recursoDto.setAula(null);
        return this;
    }

    @Override
    public RecursoBuilder fromTipoRecurso(TipoRecurso tipo) {
        recursoDto.setUser(getAlunoUser());
        recursoDto.setTipo(tipo);
        return this;
    }
}
