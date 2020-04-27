package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;

public interface AulaConfiguracaoBuilder {
    AulaConfiguracaoDto build();
    AulaConfiguracaoBuilder withIdNull();
    AulaConfiguracaoBuilder withAulnoFazUploadNull();
    AulaConfiguracaoBuilder withRespostaEmTextoNull();
    AulaConfiguracaoBuilder withTemAulaAoVivoNull();
    AulaConfiguracaoBuilder withTemDuscusaoNull();
}
