package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;

import java.time.LocalDateTime;

public class RespostaBuilder {

    private RespostaDto respostaDto;

    public RespostaBuilder() {
        respostaDto = new RespostaDto();
        respostaDto.setAtualizadoEm(LocalDateTime.now());
        respostaDto.setCriadoEm(LocalDateTime.now());
        respostaDto.setId(1);
        respostaDto.setDescricao("Aqui vai uma descrição da resposta do aluno a ser adicionada por ele");
        respostaDto.setAtividade(getAtividade());
        respostaDto.setAluno(getAluno());
    }

    private AlunoDto getAluno() {
        return AlunoBuilder.init().build();
    }

    private AtividadeDto getAtividade() {
        return new AtividadeBuilder().build();
    }

    public RespostaDto build() {
        return respostaDto;
    }

    public RespostaBuilder withIdNull() {
        respostaDto.setId(null);
        return this;
    }

    public RespostaBuilder withDescricaoNull() {
        respostaDto.setDescricao(null);
        return this;
    }

    public RespostaBuilder withCriadoEmNull() {
        respostaDto.setCriadoEm(null);
        return this;
    }

    public RespostaBuilder withAtualizadoNull() {
        respostaDto.setAtualizadoEm(null);
        return this;
    }

    public RespostaBuilder withAtividadeNull() {
        respostaDto.setAtividade(null);
        return this;
    }

    public RespostaBuilder withAlunoNull() {
        respostaDto.setAluno(null);
        return this;
    }
}
