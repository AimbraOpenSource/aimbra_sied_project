package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.enums.TipoRecurso;

public interface RecursoBuilder {
    RecursoDto build();
    RecursoBuilder withIdNull();
    RecursoBuilder withNomeRealNull();
    RecursoBuilder withNomeLogicoNull();
    RecursoBuilder withCaminhoNull();
    RecursoBuilder withTipoNull();
    RecursoBuilder withUserNull();
    RecursoBuilder withCriadoEmNull();
    RecursoBuilder withAtualizadoEmNull();
    RecursoBuilder withAulaNull();
    RecursoBuilder fromTipoRecurso(TipoRecurso tipo);

}
