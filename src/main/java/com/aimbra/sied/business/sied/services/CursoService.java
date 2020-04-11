package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.CursoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CursoService {
    List<CursoDto> findAll();
}
