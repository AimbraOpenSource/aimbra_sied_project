package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.TurmaAlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface TurmaService {
    List<TurmaDto> findAll();
    TurmaDto findById(Integer id);
    List<TurmaDto> findAllByProfessorUsername(String username);
    List<TurmaAlunoDto> findAllByAlunoUsername(String username);
    TurmaDto create(TurmaDto turmaDto);
    void deleteAll(List<TurmaDto> turmas);
    TurmaDto findByUuid(UUID uuid);
}
