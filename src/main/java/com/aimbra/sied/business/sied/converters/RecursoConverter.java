package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.entities.RecursoEntity;
import org.springframework.stereotype.Service;

@Service
public class RecursoConverter extends Converter<RecursoDto, RecursoEntity> {
    public RecursoConverter() {
        super(fromDto -> {
            var entity = new RecursoEntity();
            entity.setId(fromDto.getId());
            entity.setAtualizadoEm(fromDto.getAtualizadoEm());
            entity.setAula(new AulaConverter().toEntity(fromDto.getAula()));
            entity.setCaminho(fromDto.getCaminho());
            entity.setCriadoEm(fromDto.getCriadoEm());
            entity.setNomeReal(fromDto.getNomeReal());
            entity.setNomeLogico(fromDto.getNomeLogico());
            return entity;
        }, fromEntity -> {
            var dto = new RecursoDto();
            dto.setId(fromEntity.getId());
            dto.setAtualizadoEm(fromEntity.getAtualizadoEm());
            dto.setAula(new AulaConverter().toDto(fromEntity.getAula()));
            dto.setCaminho(fromEntity.getCaminho());
            dto.setCriadoEm(fromEntity.getCriadoEm());
            dto.setNomeReal(fromEntity.getNomeReal());
            dto.setNomeLogico(fromEntity.getNomeLogico());
            return dto;
        });
    }
}
