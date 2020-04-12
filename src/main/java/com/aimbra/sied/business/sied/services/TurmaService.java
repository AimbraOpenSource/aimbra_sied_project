package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TurmaService {
    List<TurmaDto> findAll();
    List<TurmaDto> findAllByUsername(String username);
    TurmaDto create(TurmaDto turmaDto);
    void deleteAll(List<TurmaDto> turmas);
}
