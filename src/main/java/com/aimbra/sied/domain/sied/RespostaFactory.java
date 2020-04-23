package com.aimbra.sied.domain.sied;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import com.aimbra.sied.domain.sied.entities.AlunoEntity;
import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import com.aimbra.sied.domain.sied.entities.RespostaEntity;

import java.time.LocalDateTime;

public abstract class RespostaFactory {
    public static RespostaDto toDto(Integer id, AlunoDto aluno, AtividadeDto atividade, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String caminho, String descricao) {
        RespostaDto respostaDto = new RespostaDto();
        respostaDto.setId(id);
        respostaDto.setAluno(aluno);
        respostaDto.setAtividade(atividade);
        respostaDto.setCriadoEm(criadoEm);
        respostaDto.setAtualizadoEm(atualizadoEm);
        respostaDto.setCaminho(caminho);
        respostaDto.setDescricao(descricao);
        return respostaDto;
    }

    public static RespostaEntity toEntity(Integer id, AlunoEntity aluno, AtividadeEntity atividade, LocalDateTime criadoEm, LocalDateTime atualizadoEm, String caminho, String descricao) {
        RespostaEntity entity = new RespostaEntity();
        entity.setId(id);
        entity.setAluno(aluno);
        entity.setAtividade(atividade);
        entity.setCriadoEm(criadoEm);
        entity.setAtualizadoEm(atualizadoEm);
        entity.setCaminho(caminho);
        entity.setDescricao(descricao);
        return entity;
    }
}
