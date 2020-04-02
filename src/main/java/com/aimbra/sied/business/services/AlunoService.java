package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.AlunoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlunoService {
    List<AlunoDto> findAll();
}
