package com.aimbra.sied.builders.interfaces;

import com.aimbra.sied.domain.sied.dtos.AulaDto;

public interface AulaBuilder {
    AulaDto build();
    AulaBuilder withIdNull();
    AulaBuilder withTituloNull();
    AulaBuilder withUrlVideoGravadoNull();
    AulaBuilder withDescricaoNull();
    AulaBuilder withObservacaoNull();
    AulaBuilder withTurmaNull();
    AulaBuilder withReuniaoNull();
    AulaBuilder withConfiguracaoNull();
}
