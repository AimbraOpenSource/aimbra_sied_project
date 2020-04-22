package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.TurmaAlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Function;

@Service
public class TurmaAlunoConverter extends Converter<TurmaAlunoDto, TurmaEntity> {
    public TurmaAlunoConverter() {
        super(fromDto -> {
            var entity = new TurmaEntity();
            entity.setId(fromDto.getId());
            if (fromDto.getUuid() != null) {
                entity.setUuid(UUID.fromString(fromDto.getUuid()));
            }
            entity.setCurso(new CursoConverter().toEntity(fromDto.getCurso()));
            entity.setProfessor(new ProfessorConverter().toEntity(fromDto.getProfessor()));
            entity.setSenha(fromDto.getSenha());
            return entity;
        }, fromEntity -> {
            var dto = new TurmaAlunoDto();
            dto.setId(fromEntity.getId());
            dto.setUuid(fromEntity.getUuid().toString());
            dto.setCurso(new CursoConverter().toDto(fromEntity.getCurso()));
            dto.setProfessor(new ProfessorConverter().toDto(fromEntity.getProfessor()));
            dto.setSenha(fromEntity.getSenha());
            return dto;
        });
    }
}
