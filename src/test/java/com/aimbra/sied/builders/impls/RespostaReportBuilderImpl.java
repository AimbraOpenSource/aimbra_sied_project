package com.aimbra.sied.builders.impls;


import com.aimbra.sied.builders.RespostaReportBuilder;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RespostaReportDto;

public class RespostaReportBuilderImpl implements RespostaReportBuilder {

    private RespostaReportDto respostaReportDto;

    public RespostaReportBuilderImpl() {
        respostaReportDto = new RespostaReportDto();
        respostaReportDto.setQuantidadeDispachado(10);
        respostaReportDto.setEmFalta(10);
        respostaReportDto.setQuantidadeTotal(20);
        respostaReportDto.setAluno(getAluno());
        respostaReportDto.setAula(getAula());
    }

    private AlunoDto getAluno() {
        return new AlunoBuilderImpl().build();
    }

    private AulaDto getAula() {
        return new AulaBuilderImpl().build();
    }

    @Override
    public RespostaReportDto build() {
        return respostaReportDto;
    }

    @Override
    public RespostaReportBuilder withQuantidadeTotalNull() {
        respostaReportDto.setQuantidadeTotal(null);
        return this;
    }

    @Override
    public RespostaReportBuilder withQuantidadeDispachadoNull() {
        respostaReportDto.setQuantidadeDispachado(null);
        return this;
    }

    @Override
    public RespostaReportBuilder withEmFaltaNull() {
        respostaReportDto.setEmFalta(null);
        return this;
    }

    @Override
    public RespostaReportBuilder withAlunoNull() {
        respostaReportDto.setAluno(null);
        return this;
    }

    @Override
    public RespostaReportBuilder withAulaNull() {
        respostaReportDto.setAula(null);
        return this;
    }
}
