package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.InscricaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;

public class InscricaoBuilder {

    private InscricaoDto inscricaoDto;

    public InscricaoBuilder() {
        inscricaoDto = new InscricaoDto();
        inscricaoDto.setTurma(getTurma());
        inscricaoDto.setAluno(getAluno());
    }

    private TurmaDto getTurma() {
        return TurmaBuilder.init().build();
    }

    private AlunoDto getAluno() {
        return AlunoBuilder.init().build();
    }

    public InscricaoDto build() {
        return inscricaoDto;
    }

    public InscricaoBuilder withTurmaNull() {
        inscricaoDto.setTurma(null);
        return this;
    }

    public InscricaoBuilder withAlunoNull() {
        inscricaoDto.setAluno(null);
        return this;
    }
}
