package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RespostaService {
    List<RespostaDto> findAll();
}
