package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.entities.AlunoEntity;
import com.aimbra.sied.security.sied.converters.UserConverter;
import org.springframework.stereotype.Service;


@Service
public class AlunoConverter extends Converter<AlunoDto, AlunoEntity> {
    public AlunoConverter() {
        super(fromDto -> {
            var entity = new AlunoEntity();
            entity.setId(fromDto.getId());
            entity.setNome(fromDto.getNome());
            entity.setTurmas(new TurmaConverter().toEntityList(fromDto.getTurmas()));
            entity.setUser(new UserConverter().toEntity(fromDto.getUser()));
            return entity;
        }, fromEntity -> {
            var dto = new AlunoDto();
            dto.setId(fromEntity.getId());
            dto.setNome(fromEntity.getNome());
            dto.setTurmas(new TurmaConverter().toDtoList(fromEntity.getTurmas()));
            dto.setUser(new UserConverter().toDto(fromEntity.getUser()));
            return dto;
        });
    }
}
