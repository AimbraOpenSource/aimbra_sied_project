package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.ProfessorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    List<ProfessorDto> findAll();
    ProfessorDto save(ProfessorDto dto);
}
