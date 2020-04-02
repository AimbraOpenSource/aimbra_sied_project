package com.aimbra.sied.business.converters;

import com.aimbra.sied.domain.dtos.ProfessorDto;
import com.aimbra.sied.domain.entities.ProfessorEntity;
import com.aimbra.sied.security.converters.UserConverter;
import org.springframework.stereotype.Service;

@Service
public class ProfessorConverter extends Converter<ProfessorDto, ProfessorEntity> {
    public ProfessorConverter() {
        super(fromDto -> {
            var entity = new ProfessorEntity();
            entity.setId(fromDto.getId());
            entity.setNome(fromDto.getNome());
            entity.setUser(new UserConverter().toEntity(fromDto.getUser()));
            return entity;
        }, fromEntity -> {
            var dto = new ProfessorDto();
            dto.setId(fromEntity.getId());
            dto.setNome(fromEntity.getNome());
            dto.setUser(new UserConverter().toDto(fromEntity.getUser()));
            return dto;
        });
    }
}
