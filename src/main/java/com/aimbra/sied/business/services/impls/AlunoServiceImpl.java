package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.AlunoConverter;
import com.aimbra.sied.business.services.AlunoService;
import com.aimbra.sied.domain.dtos.AlunoDto;
import com.aimbra.sied.infra.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoConverter converter;

    @Override
    public List<AlunoDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
