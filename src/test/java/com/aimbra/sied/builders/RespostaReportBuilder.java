package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.RespostaReportDto;

public interface RespostaReportBuilder {
    RespostaReportDto build();
    RespostaReportBuilder withQuantidadeTotalNull();
    RespostaReportBuilder withQuantidadeDispachadoNull();
    RespostaReportBuilder withEmFaltaNull();
    RespostaReportBuilder withAlunoNull();
    RespostaReportBuilder withAulaNull();
}
