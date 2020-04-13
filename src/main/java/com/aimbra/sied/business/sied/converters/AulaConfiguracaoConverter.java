package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;
import com.aimbra.sied.domain.sied.entities.AulaConfiguracaoEntity;

import java.util.function.Function;

public class AulaConfiguracaoConverter extends Converter<AulaConfiguracaoDto, AulaConfiguracaoEntity> {
    public AulaConfiguracaoConverter() {
        super(fromDto -> {
            AulaConfiguracaoEntity entity = new AulaConfiguracaoEntity();
            if (fromDto.getId() != null) {
                entity.setId(fromDto.getId());
            }
            entity.setRespostaTemTexto(fromDto.isRespostaTemTexto());
            entity.setAlunoFazUpload(fromDto.isAlunoFazUpload());
            entity.setTemAgendamento(fromDto.isTemAgendamento());
            entity.setTemAulaAoVivo(fromDto.isTemAulaAoVivo());
            entity.setTemDiscusao(fromDto.isTemDiscusao());
            return entity;
        }, fromEntity -> {
            AulaConfiguracaoDto dto = new AulaConfiguracaoDto();
            if (fromEntity.getId() != null) {
                dto.setId(fromEntity.getId());
            }
            dto.setRespostaTemTexto(fromEntity.isRespostaTemTexto());
            dto.setAlunoFazUpload(fromEntity.isAlunoFazUpload());
            dto.setTemAgendamento(fromEntity.isTemAgendamento());
            dto.setTemAulaAoVivo(fromEntity.isTemAulaAoVivo());
            dto.setTemDiscusao(fromEntity.isTemDiscusao());
            return dto;
        });
    }
}
