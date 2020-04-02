package com.aimbra.sied.business.services;

import com.aimbra.sied.domain.dtos.ReuniaoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReuniaoService {
    List<ReuniaoDto> findAll();
}
