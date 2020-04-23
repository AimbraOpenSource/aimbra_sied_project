package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.entities.RecursoEntity;
import com.aimbra.sied.security.sied.converters.UserConverter;
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
            entity.setTipo(fromDto.getTipo());
            entity.setUser(new UserConverter().toEntity(fromDto.getUser()));
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
            dto.setUser(new UserConverter().toDto(fromEntity.getUser()));
            dto.setTipo(fromEntity.getTipo());
            dto.setCriadoEm(fromEntity.getCriadoEm());
            dto.setNomeReal(fromEntity.getNomeReal());
            dto.setNomeLogico(fromEntity.getNomeLogico());
            return dto;
        });
    }
}
