package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.AlunoConverter;
import com.aimbra.sied.business.converters.AulaConverter;
import com.aimbra.sied.business.services.AulaService;
import com.aimbra.sied.domain.dtos.AulaDto;
import com.aimbra.sied.infra.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository repository;

    @Autowired
    private AulaConverter converter;

    @Override
    public List<AulaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
