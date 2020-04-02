package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.RecursoConverter;
import com.aimbra.sied.business.services.RecursoService;
import com.aimbra.sied.domain.dtos.RecursoDto;
import com.aimbra.sied.infra.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    private RecursoRepository repository;

    @Autowired
    private RecursoConverter converter;

    @Override
    public List<RecursoDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
