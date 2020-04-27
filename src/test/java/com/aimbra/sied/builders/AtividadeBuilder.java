package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;

import java.time.LocalDateTime;

public class AtividadeBuilder {

    private AtividadeDto atividadeDto;

    public AtividadeBuilder() {
        atividadeDto = new AtividadeDto();
        atividadeDto.setId(1);
        atividadeDto.setTitulo("Teste de Titulo para atividade");
        atividadeDto.setDescricao("Teste de descrição a ser adiciondo na atividade. Este será o exercicio a ser implementado pelo professor e respondido pelo aluno");
        atividadeDto.setCriadoEm(LocalDateTime.now());
        atividadeDto.setLiberadoEm(LocalDateTime.now());
        atividadeDto.setAula(getAula());
    }

    private AulaDto getAula() {
        return new AulaBuilder().build();
    }

    public AtividadeDto build() {
        return atividadeDto;
    }

    public AtividadeBuilder withIdNull() {
        atividadeDto.setId(null);
        return this;
    }

    public AtividadeBuilder withTituloNull() {
        atividadeDto.setTitulo(null);
        return this;
    }

    public AtividadeBuilder withDescricaoNull() {
        atividadeDto.setDescricao(null);
        return this;
    }

    public AtividadeBuilder withAulaNull() {
        atividadeDto.setAula(null);
        return this;
    }

    public AtividadeBuilder withCriadoEmNull() {
        atividadeDto.setCriadoEm(null);
        return this;
    }

    public AtividadeBuilder withLiberadoEmNull() {
        atividadeDto.setLiberadoEm(null);
        return this;
    }
}
