package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.AulaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AulaService {
    List<AulaDto> findAll();
}
