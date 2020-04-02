package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TurmaService {
    List<TurmaDto> findAll();
}
