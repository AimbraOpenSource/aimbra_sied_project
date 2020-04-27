package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;

public class AulaBuilder {

    private AulaDto aula;

    public AulaBuilder() {
        aula = new AulaDto();
        aula.setId(1);
        aula.setTitulo("Titulo da Aula original");
        aula.setDescricao("Este aqui é a descrição da aula. Não é a descrição da atividade!");
        aula.setObservacao("Aqui vai uma observação a ser adicionaddo como exemplo de persinst!");
        aula.setTurma(getTurma());
        aula.setReuniao(getReuniao());
        aula.setConfiguracao(getConfiguracao());
    }

    private TurmaDto getTurma() {
        return TurmaBuilder.init().build();
    }

    private ReuniaoDto getReuniao() {
        return ReuniaoBuilder.init().build();
    }

    private AulaConfiguracaoDto getConfiguracao() {
        return new AulaConfiguracaoBuilder().build();
    }

    public AulaDto build() {
        return aula;
    }

    public AulaBuilder withIdNull() {
        aula.setId(null);
        return this;
    }

    public AulaBuilder withTituloNull() {
        aula.setTitulo(null);
        return this;
    }

    public AulaBuilder withUrlVideoGravadoNull() {
        aula.setUrlVideoGravado(null);
        return this;
    }

    public AulaBuilder withDescricaoNull() {
        aula.setDescricao(null);
        return this;
    }

    public AulaBuilder withObservacaoNull() {
        aula.setObservacao(null);
        return this;
    }

    public AulaBuilder withTurmaNull() {
        aula.setTurma(null);
        return this;
    }

    public AulaBuilder withReuniaoNull() {
        aula.setReuniao(null);
        return this;
    }

    public AulaBuilder withConfiguracaoNull() {
        aula.setConfiguracao(null);
        return this;
    }
}
