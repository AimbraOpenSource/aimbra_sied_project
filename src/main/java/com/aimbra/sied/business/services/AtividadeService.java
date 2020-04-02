package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.AtividadeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AtividadeService {
    List<AtividadeDto> findAll();
}
