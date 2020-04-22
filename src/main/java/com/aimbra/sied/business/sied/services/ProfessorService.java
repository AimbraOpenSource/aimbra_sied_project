package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    List<ProfessorDto> findAll();
    ProfessorDto save(ProfessorDto dto);
    ProfessorDto findByUsername(String username);
    ProfessorDto findById(Integer id);
}
