package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaAlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AlunoService {
    List<AlunoDto> findAll();
    List<TurmaAlunoDto> findAllTurmasByUsername(String username);
    List<AlunoDto> findAllAlunosOfProfessor(String username);
    AlunoDto findByUsername(String username);
    AlunoDto save(AlunoDto dto);
    Boolean existsOnTurmaUuidAndUsername(UUID uuid, String username);
}
