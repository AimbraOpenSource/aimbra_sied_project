package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.interfaces.AlunoBuilder;
import com.aimbra.sied.builders.interfaces.ProfessorBuilder;
import com.aimbra.sied.builders.interfaces.TurmaBuilder;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.CursoDto;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TurmaBuilderImpl implements TurmaBuilder {

    private TurmaDto turmaDto;

    public TurmaBuilderImpl() {
        turmaDto = new TurmaDto();
        turmaDto.setId(1);
        turmaDto.setUuid(UUID.randomUUID().toString());
        turmaDto.setSenha("123123");
        turmaDto.setProfessor(getProfessor());
        turmaDto.setAlunos(getAlunos());
        turmaDto.setCurso(getCurso());
    }

    private ProfessorDto getProfessor() {
        return new ProfessorBuilderImpl().build();
    }

    private List<AlunoDto> getAlunos() {
        return List.of(
                new AlunoBuilderImpl().build(),
                new AlunoBuilderImpl().build(),
                new AlunoBuilderImpl().build()
        );
    }

    private CursoDto getCurso() {
        return new CursoBuilderImpl().build();
    }

    @Override
    public TurmaDto build() {
        return turmaDto;
    }

    @Override
    public TurmaBuilder withIdNull() {
        turmaDto.setId(null);
        return this;
    }

    @Override
    public TurmaBuilder withUuidNull() {
        turmaDto.setUuid(null);
        return this;
    }

    @Override
    public TurmaBuilder withsenhaNull() {
        turmaDto.setSenha(null);
        return this;
    }

    @Override
    public TurmaBuilder withCursoNull() {
        turmaDto.setCurso(null);
        return this;
    }

    @Override
    public TurmaBuilder withProfessorNull() {
        turmaDto.setProfessor(null);
        return this;
    }

    @Override
    public TurmaBuilder withAlunosNull() {
        turmaDto.setAlunos(null);
        return this;
    }

    @Override
    public TurmaBuilder withAlunosEmpty() {
        turmaDto.setAlunos(new ArrayList<>());
        return this;
    }
}
