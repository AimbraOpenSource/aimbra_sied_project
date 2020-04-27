package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;

public class AulaConfiguracaoBuilder{

    private AulaConfiguracaoDto configuracao;

    public AulaConfiguracaoBuilder() {
        configuracao = new AulaConfiguracaoDto();
        configuracao.setAlunoFazUpload(true);
        configuracao.setId(1);
        configuracao.setRespostaTemTexto(true);
        configuracao.setTemAgendamento(true);
        configuracao.setTemAulaAoVivo(true);
        configuracao.setTemDiscusao(true);
    }

    public AulaConfiguracaoDto build() {
        return configuracao;
    }

    public AulaConfiguracaoBuilder withIdNull() {
        configuracao.setId(null);
        return this;
    }

    public AulaConfiguracaoBuilder withAulnoFazUploadNull() {
        configuracao.setAlunoFazUpload(null);
        return this;
    }

    public AulaConfiguracaoBuilder withRespostaEmTextoNull() {
        configuracao.setRespostaTemTexto(null);
        return this;
    }

    public AulaConfiguracaoBuilder withTemAulaAoVivoNull() {
        configuracao.setTemAulaAoVivo(null);
        return this;
    }

    public AulaConfiguracaoBuilder withTemDuscusaoNull() {
        configuracao.setTemDiscusao(null);
        return this;
    }
}
