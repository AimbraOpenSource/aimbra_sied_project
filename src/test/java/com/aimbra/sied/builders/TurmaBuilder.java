package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.CursoDto;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TurmaBuilder {

    private TurmaDto turmaDto;

    private TurmaBuilder() {
    }

    public static TurmaBuilder init() {
        TurmaBuilder builder = new TurmaBuilder();
        builder.turmaDto = new TurmaDto();
        builder.turmaDto.setId(1);
        builder.turmaDto.setUuid(UUID.randomUUID().toString());
        builder.turmaDto.setSenha("123123");
        builder.turmaDto.setProfessor(builder.getProfessor());
        builder.turmaDto.setAlunos(builder.getAlunos());
        builder.turmaDto.setCurso(builder.getCurso());
        return builder;
    }

    private ProfessorDto getProfessor() {
        return new ProfessorBuilder().build();
    }

    private List<AlunoDto> getAlunos() {
        return List.of(
                AlunoBuilder.init().build(),
                AlunoBuilder.init().build(),
                AlunoBuilder.init().build()
        );
    }

    private CursoDto getCurso() {
        return new CursoBuilder().build();
    }

    public TurmaDto build() {
        return turmaDto;
    }

    public TurmaBuilder withIdNull() {
        turmaDto.setId(null);
        return this;
    }

    public TurmaBuilder withUuidNull() {
        turmaDto.setUuid(null);
        return this;
    }

    public TurmaBuilder withsenhaNull() {
        turmaDto.setSenha(null);
        return this;
    }

    public TurmaBuilder withCursoNull() {
        turmaDto.setCurso(null);
        return this;
    }

    public TurmaBuilder withProfessorNull() {
        turmaDto.setProfessor(null);
        return this;
    }

    public TurmaBuilder withAlunosNull() {
        turmaDto.setAlunos(null);
        return this;
    }

    public TurmaBuilder withAlunosEmpty() {
        turmaDto.setAlunos(new ArrayList<>());
        return this;
    }
}
