package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlunoService {
    List<AlunoDto> findAll();
    List<TurmaDto> findAllTurmasByUsername(String username);
    AlunoDto findByUsername(String username);
    AlunoDto save(AlunoDto dto);
}
