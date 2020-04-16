package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AulaService {
    List<AulaDto> findAll();
    AulaDto findById(Integer id);
    List<AulaDto> findAllByTurmaIdAndUserLoggedIn(Integer turmaId, String username);

    Integer findMaxOrderByTurmaId(Integer turmaId);
}
