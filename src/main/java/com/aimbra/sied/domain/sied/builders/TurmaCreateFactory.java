package com.aimbra.sied.domain.sied.builders;

import com.aimbra.sied.domain.sied.dtos.CursoDto;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;

public abstract class TurmaCreateFactory {
    public static TurmaDto create(CursoDto curso, ProfessorDto professor) {
        TurmaDto dto = new TurmaDto();
        dto.setCurso(curso);
        dto.setProfessor(professor);
        return dto;
    }
}
