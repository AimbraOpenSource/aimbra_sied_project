package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.InscricaoDto;

public interface InscricaoBuilder {
    InscricaoDto build();
    InscricaoBuilder withTurmaNull();
    InscricaoBuilder withAlunoNull();
}
