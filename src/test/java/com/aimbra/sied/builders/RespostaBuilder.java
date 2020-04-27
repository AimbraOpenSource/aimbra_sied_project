package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.RespostaDto;

public interface RespostaBuilder {
    RespostaDto build();
    RespostaBuilder withIdNull();
    RespostaBuilder withDescricaoNull();
    RespostaBuilder withCriadoEmNull();
    RespostaBuilder withAtualizadoNull();
    RespostaBuilder withAtividadeNull();
    RespostaBuilder withAlunoNull();
}
