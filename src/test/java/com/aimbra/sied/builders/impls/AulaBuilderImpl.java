package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.AulaBuilder;
import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;

public class AulaBuilderImpl implements AulaBuilder {

    private AulaDto aula;

    public AulaBuilderImpl() {
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
        return new TurmaBuilderImpl().build();
    }

    private ReuniaoDto getReuniao() {
        return new ReuniaoBuilderImpl().build();
    }

    private AulaConfiguracaoDto getConfiguracao() {
        return new AulaConfiguracaoBuilderImpl().build();
    }

    @Override
    public AulaDto build() {
        return aula;
    }

    @Override
    public AulaBuilder withIdNull() {
        aula.setId(null);
        return this;
    }

    @Override
    public AulaBuilder withTituloNull() {
        aula.setTitulo(null);
        return this;
    }

    @Override
    public AulaBuilder withUrlVideoGravadoNull() {
        aula.setUrlVideoGravado(null);
        return this;
    }

    @Override
    public AulaBuilder withDescricaoNull() {
        aula.setDescricao(null);
        return this;
    }

    @Override
    public AulaBuilder withObservacaoNull() {
        aula.setObservacao(null);
        return this;
    }

    @Override
    public AulaBuilder withTurmaNull() {
        aula.setTurma(null);
        return this;
    }

    @Override
    public AulaBuilder withReuniaoNull() {
        aula.setReuniao(null);
        return this;
    }

    @Override
    public AulaBuilder withConfiguracaoNull() {
        aula.setConfiguracao(null);
        return this;
    }
}
