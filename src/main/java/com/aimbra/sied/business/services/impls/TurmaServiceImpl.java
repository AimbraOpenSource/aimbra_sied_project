package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.TurmaConverter;
import com.aimbra.sied.business.services.TurmaService;
import com.aimbra.sied.domain.dtos.TurmaDto;
import com.aimbra.sied.infra.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private TurmaConverter converter;

    @Override
    public List<TurmaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
