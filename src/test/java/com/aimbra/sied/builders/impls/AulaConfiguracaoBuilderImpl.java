package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.interfaces.AulaConfiguracaoBuilder;
import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;

public class AulaConfiguracaoBuilderImpl implements AulaConfiguracaoBuilder {

    private AulaConfiguracaoDto configuracao;

    public AulaConfiguracaoBuilderImpl() {
        configuracao = new AulaConfiguracaoDto();
        configuracao.setAlunoFazUpload(true);
        configuracao.setId(1);
        configuracao.setRespostaTemTexto(true);
        configuracao.setTemAgendamento(true);
        configuracao.setTemAulaAoVivo(true);
        configuracao.setTemDiscusao(true);
    }

    @Override
    public AulaConfiguracaoDto build() {
        return configuracao;
    }

    @Override
    public AulaConfiguracaoBuilder withIdNull() {
        configuracao.setId(null);
        return this;
    }

    @Override
    public AulaConfiguracaoBuilder withAulnoFazUploadNull() {
        configuracao.setAlunoFazUpload(null);
        return this;
    }

    @Override
    public AulaConfiguracaoBuilder withRespostaEmTextoNull() {
        configuracao.setRespostaTemTexto(null);
        return this;
    }

    @Override
    public AulaConfiguracaoBuilder withTemAulaAoVivoNull() {
        configuracao.setTemAulaAoVivo(null);
        return this;
    }

    @Override
    public AulaConfiguracaoBuilder withTemDuscusaoNull() {
        configuracao.setTemDiscusao(null);
        return this;
    }
}
