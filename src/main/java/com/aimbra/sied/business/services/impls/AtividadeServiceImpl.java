package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.AtividadeConverter;
import com.aimbra.sied.business.services.AtividadeService;
import com.aimbra.sied.domain.dtos.AtividadeDto;
import com.aimbra.sied.infra.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private AtividadeConverter converter;

    @Override
    public List<AtividadeDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
