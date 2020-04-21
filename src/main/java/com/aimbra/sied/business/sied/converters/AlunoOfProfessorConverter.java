package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.AlunoOfProfessorDto;
import com.aimbra.sied.infra.projections.AlunoOfProfessorProjection;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AlunoOfProfessorConverter extends Converter<AlunoOfProfessorDto, AlunoOfProfessorProjection> {
    public AlunoOfProfessorConverter() {
        super(fromDto -> {
            throw new RuntimeException("Esta classe é somente para modo de visualização");
        }, fromEntity -> {
            var dto = new AlunoOfProfessorDto();
            dto.setNome(fromEntity.getNome());
            dto.setId(fromEntity.getId());
            dto.setCurso(fromEntity.getCurso());
            dto.setCursoId(fromEntity.getCursoId());
            dto.setProfessor(fromEntity.getProfessor());
            dto.setProfessorId(fromEntity.getProfessorId());
            return dto;
        });
    }
}
