package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AtividadeDto;

public interface AtividadeBuilder {
    AtividadeDto build();
    AtividadeBuilder withIdNull();
    AtividadeBuilder withTituloNull();
    AtividadeBuilder withDescricaoNull();
    AtividadeBuilder withAulaNull();
    AtividadeBuilder withCriadoEmNull();
    AtividadeBuilder withLiberadoEmNull();
}
