package com.aimbra.sied.builders;


import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RespostaReportDto;

public class RespostaReportBuilder {

    private RespostaReportDto respostaReportDto;

    public RespostaReportBuilder() {
        respostaReportDto = new RespostaReportDto();
        respostaReportDto.setQuantidadeDispachado(10);
        respostaReportDto.setEmFalta(10);
        respostaReportDto.setQuantidadeTotal(20);
        respostaReportDto.setAluno(getAluno());
        respostaReportDto.setAula(getAula());
    }

    private AlunoDto getAluno() {
        return AlunoBuilder.init().build();
    }

    private AulaDto getAula() {
        return new AulaBuilder().build();
    }

    public RespostaReportDto build() {
        return respostaReportDto;
    }

    public RespostaReportBuilder withQuantidadeTotalNull() {
        respostaReportDto.setQuantidadeTotal(null);
        return this;
    }

    public RespostaReportBuilder withQuantidadeDispachadoNull() {
        respostaReportDto.setQuantidadeDispachado(null);
        return this;
    }

    public RespostaReportBuilder withEmFaltaNull() {
        respostaReportDto.setEmFalta(null);
        return this;
    }

    public RespostaReportBuilder withAlunoNull() {
        respostaReportDto.setAluno(null);
        return this;
    }

    public RespostaReportBuilder withAulaNull() {
        respostaReportDto.setAula(null);
        return this;
    }
}
