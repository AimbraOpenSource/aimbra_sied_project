package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecursoService {
    List<RecursoDto> findAll();
}
