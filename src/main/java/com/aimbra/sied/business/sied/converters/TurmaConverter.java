package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TurmaConverter extends Converter<TurmaDto, TurmaEntity> {
    public TurmaConverter() {
        super(fromDto -> {
            var entity = new TurmaEntity();
            entity.setId(fromDto.getId());
            if (fromDto.getUuid() != null) {
                entity.setUuid(UUID.fromString(fromDto.getUuid()));
            }
            entity.setAlunos(new AlunoConverter().toEntityList(fromDto.getAlunos()));
            entity.setCurso(new CursoConverter().toEntity(fromDto.getCurso()));
            entity.setProfessor(new ProfessorConverter().toEntity(fromDto.getProfessor()));
            entity.setSenha(fromDto.getSenha());
            return entity;
        }, fromEntity -> {
            var dto = new TurmaDto();
            dto.setId(fromEntity.getId());
            dto.setUuid(fromEntity.getUuid().toString());
            dto.setAlunos(new AlunoConverter().toDtoList(fromEntity.getAlunos()));
            dto.setCurso(new CursoConverter().toDto(fromEntity.getCurso()));
            dto.setProfessor(new ProfessorConverter().toDto(fromEntity.getProfessor()));
            dto.setSenha(fromEntity.getSenha());
            return dto;
        });
    }
}
