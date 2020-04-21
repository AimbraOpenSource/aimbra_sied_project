package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscricaoService {
    List<TurmaDto> findAll();
    TurmaDto insertAluno(String username, String turmaUuid, String senhaTurma);
    void removeByAlunoIdAndTurmaId(Integer alunoId, Integer turmaId);
}
