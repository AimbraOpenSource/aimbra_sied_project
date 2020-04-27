package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.InscricaoBuilder;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.InscricaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;

public class InscricaoBuilderimpl implements InscricaoBuilder {

    private InscricaoDto inscricaoDto;

    public InscricaoBuilderimpl() {
        inscricaoDto = new InscricaoDto();
        inscricaoDto.setTurma(getTurma());
        inscricaoDto.setAluno(getAluno());
    }

    private TurmaDto getTurma() {
        return new TurmaBuilderImpl().build();
    }

    private AlunoDto getAluno() {
        return new AlunoBuilderImpl().build();
    }

    @Override
    public InscricaoDto build() {
        return inscricaoDto;
    }

    @Override
    public InscricaoBuilder withTurmaNull() {
        inscricaoDto.setTurma(null);
        return this;
    }

    @Override
    public InscricaoBuilder withAlunoNull() {
        inscricaoDto.setAluno(null);
        return this;
    }
}
