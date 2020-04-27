package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;

import java.time.LocalDateTime;

public class RecursoBuilder {

    RecursoDto recursoDto;

    public RecursoBuilder() {
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
        return new AulaBuilder().build();
    }

    private UserDto getProfessorUser() {
        return UserBuilder.init(UserRole.PROFESSOR).build();
    }

    private UserDto getAlunoUser() {
        return UserBuilder.init(UserRole.ALUNO).build();
    }

    public RecursoDto build() {
        return recursoDto;
    }

    public RecursoBuilder withIdNull() {
        recursoDto.setId(null);
        return this;
    }

    public RecursoBuilder withNomeRealNull() {
        recursoDto.setNomeReal(null);
        return this;
    }

    public RecursoBuilder withNomeLogicoNull() {
        recursoDto.setNomeLogico(null);
        return this;
    }

    public RecursoBuilder withCaminhoNull() {
        recursoDto.setCaminho(null);
        return this;
    }

    public RecursoBuilder withTipoNull() {
        recursoDto.setTipo(null);
        return this;
    }

    public RecursoBuilder withUserNull() {
        recursoDto.setUser(null);
        return this;
    }

    public RecursoBuilder withCriadoEmNull() {
        recursoDto.setCriadoEm(null);
        return this;
    }

    public RecursoBuilder withAtualizadoEmNull() {
        recursoDto.setAtualizadoEm(null);
        return this;
    }

    public RecursoBuilder withAulaNull() {
        recursoDto.setAula(null);
        return this;
    }

    public RecursoBuilder fromTipoRecurso(TipoRecurso tipo) {
        recursoDto.setUser(getAlunoUser());
        recursoDto.setTipo(tipo);
        return this;
    }
}
