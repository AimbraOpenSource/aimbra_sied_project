package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.RespostaBuilder;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;

import java.time.LocalDateTime;

public class RespostaBuilderImpl implements RespostaBuilder {

    private RespostaDto respostaDto;

    public RespostaBuilderImpl() {
        respostaDto = new RespostaDto();
        respostaDto.setAtualizadoEm(LocalDateTime.now());
        respostaDto.setCriadoEm(LocalDateTime.now());
        respostaDto.setId(1);
        respostaDto.setDescricao("Aqui vai uma descrição da resposta do aluno a ser adicionada por ele");
        respostaDto.setAtividade(getAtividade());
        respostaDto.setAluno(getAluno());
    }

    private AlunoDto getAluno() {
        return new AlunoBuilderImpl().build();
    }

    private AtividadeDto getAtividade() {
        return new AtividadeBuilderImpl().build();
    }

    @Override
    public RespostaDto build() {
        return respostaDto;
    }

    @Override
    public RespostaBuilder withIdNull() {
        respostaDto.setId(null);
        return this;
    }

    @Override
    public RespostaBuilder withDescricaoNull() {
        respostaDto.setDescricao(null);
        return this;
    }

    @Override
    public RespostaBuilder withCriadoEmNull() {
        respostaDto.setCriadoEm(null);
        return this;
    }

    @Override
    public RespostaBuilder withAtualizadoNull() {
        respostaDto.setAtualizadoEm(null);
        return this;
    }

    @Override
    public RespostaBuilder withAtividadeNull() {
        respostaDto.setAtividade(null);
        return this;
    }

    @Override
    public RespostaBuilder withAlunoNull() {
        respostaDto.setAluno(null);
        return this;
    }
}
