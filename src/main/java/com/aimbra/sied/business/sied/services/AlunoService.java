package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlunoService {
    List<AlunoDto> findAll();
    AlunoDto findByUsername(String username);
    AlunoDto save(AlunoDto dto);
}
