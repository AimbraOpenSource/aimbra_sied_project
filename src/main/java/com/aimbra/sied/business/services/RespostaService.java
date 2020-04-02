package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.RespostaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RespostaService {
    List<RespostaDto> findAll();
}
