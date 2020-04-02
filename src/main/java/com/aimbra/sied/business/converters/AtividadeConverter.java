package com.aimbra.sied.business.converters;

import com.aimbra.sied.domain.dtos.AtividadeDto;
import com.aimbra.sied.domain.entities.AtividadeEntity;
import org.springframework.stereotype.Service;

@Service
public class AtividadeConverter extends Converter<AtividadeDto, AtividadeEntity> {
    public AtividadeConverter() {
        super(fromDto -> {
            var entity = new AtividadeEntity();
            entity.setId(fromDto.getId());
            entity.setAula(new AulaConverter().toEntity(fromDto.getAula()));
            entity.setCriadoEm(fromDto.getCriadoEm());
            entity.setLiberadoEm(fromDto.getLiberadoEm());
            entity.setDescricao(fromDto.getDescricao());
            entity.setTitulo(fromDto.getTitulo());
            return entity;
        }, fromEntity -> {
            var dto = new AtividadeDto();
            dto.setId(fromEntity.getId());
            dto.setAula(new AulaConverter().toDto(fromEntity.getAula()));
            dto.setCriadoEm(fromEntity.getCriadoEm());
            dto.setLiberadoEm(fromEntity.getLiberadoEm());
            dto.setDescricao(fromEntity.getDescricao());
            dto.setTitulo(fromEntity.getTitulo());
            return dto;
        });
    }
}
