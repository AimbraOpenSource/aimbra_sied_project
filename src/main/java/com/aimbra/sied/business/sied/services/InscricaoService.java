package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscricaoService {
    public List<TurmaDto> findAll();
    public TurmaDto insertAluno(String username, String turmaUuid, String senhaTurma);
}
