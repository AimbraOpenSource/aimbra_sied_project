package com.aimbra.sied.infra.projections;

import com.aimbra.sied.domain.sied.entities.AlunoEntity;
import com.aimbra.sied.domain.sied.entities.ProfessorEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "aluno", types = {
        AlunoEntity.class
})
public interface AlunoOfProfessorProjection {
    @Value("#{target.id}")
    Integer getId();

    @Value("#{target.nome}")
    String getNome();

    @Value("#{target.professorId}")
    Integer getProfessorId();

    @Value("#{target.professor}")
    String getProfessor();

    @Value("#{target.cursoId}")
    Integer getCursoId();

    @Value("#{target.curso}")
    String getCurso();

}
