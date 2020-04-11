package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.TurmaConverter;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
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
