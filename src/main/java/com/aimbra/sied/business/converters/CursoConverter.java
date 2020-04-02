package com.aimbra.sied.business.converters;

import com.aimbra.sied.domain.dtos.CursoDto;
import com.aimbra.sied.domain.entities.CursoEntity;
import org.springframework.stereotype.Service;


@Service
public class CursoConverter extends Converter<CursoDto, CursoEntity> {

    public CursoConverter() {
        super(fromDto -> {
            var entity = new CursoEntity();
            entity.setId(fromDto.getId());
            entity.setNome(fromDto.getNome());
            return entity;
        }, fromEntity -> {
            var dto = new CursoDto();
            dto.setId(fromEntity.getId());
            dto.setNome(fromEntity.getNome());
            return dto;
        });
    }
}
