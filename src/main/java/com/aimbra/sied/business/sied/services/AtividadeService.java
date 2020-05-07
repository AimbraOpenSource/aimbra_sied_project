package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AtividadeService {
    List<AtividadeDto> findAll();
    AtividadeDto insert(AtividadeDto dto);
    AtividadeDto findById(Integer id);
    AtividadeDto findByAulaId(Integer id);
    void deleteByAulaId(Integer aulaId);

    AtividadeDto update(AtividadeDto atividadeDto);
}
