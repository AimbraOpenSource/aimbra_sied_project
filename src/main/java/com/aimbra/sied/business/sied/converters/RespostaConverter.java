package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import com.aimbra.sied.domain.sied.entities.RespostaEntity;
import org.springframework.stereotype.Service;

@Service
public class RespostaConverter extends Converter<RespostaDto, RespostaEntity> {
    public RespostaConverter() {
        super(fromDto -> {
            var entity = new RespostaEntity();
            entity.setId(fromDto.getId());
            entity.setAluno(new AlunoConverter().toEntity(fromDto.getAluno()));
            entity.setAtividade(new AtividadeConverter().toEntity(fromDto.getAtividade()));
            entity.setAtualizadoEm(fromDto.getAtualizadoEm());
            entity.setCriadoEm(fromDto.getCriadoEm());
            entity.setCaminho(fromDto.getCaminho());
            entity.setDescricao(fromDto.getDescricao());
            return entity;
        }, fromEntity -> {
            var dto = new RespostaDto();
            dto.setId(fromEntity.getId());
            dto.setAluno(new AlunoConverter().toDto(fromEntity.getAluno()));
            dto.setAtividade(new AtividadeConverter().toDto(fromEntity.getAtividade()));
            dto.setAtualizadoEm(fromEntity.getAtualizadoEm());
            dto.setCriadoEm(fromEntity.getCriadoEm());
            dto.setCaminho(fromEntity.getCaminho());
            dto.setDescricao(fromEntity.getDescricao());
            return dto;
        });
    }
}
