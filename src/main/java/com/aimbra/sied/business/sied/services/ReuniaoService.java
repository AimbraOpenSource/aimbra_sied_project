package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReuniaoService {
    List<ReuniaoDto> findAll();
    ReuniaoDto saveFromAula(AulaDto aulaDto);
}
