package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.RecursoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecursoService {
    List<RecursoDto> findAll();
}
