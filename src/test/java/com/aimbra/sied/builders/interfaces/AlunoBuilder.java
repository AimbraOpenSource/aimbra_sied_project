package com.aimbra.sied.builders.interfaces;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.AlunoEntity;

import java.util.List;

public interface AlunoBuilder {
    AlunoDto build();
    AlunoBuilder withIdNull();
    AlunoBuilder withUserNull();
    AlunoBuilder withTurmasNull();
    AlunoBuilder withTurmas(List<TurmaDto> turmas);
}
