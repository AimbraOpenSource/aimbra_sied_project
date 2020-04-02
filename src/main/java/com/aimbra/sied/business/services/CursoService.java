package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.CursoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CursoService {
    List<CursoDto> findAll();
}
