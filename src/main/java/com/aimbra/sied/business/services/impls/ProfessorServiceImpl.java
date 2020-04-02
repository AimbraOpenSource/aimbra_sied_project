package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.ProfessorConverter;
import com.aimbra.sied.business.services.ProfessorService;
import com.aimbra.sied.domain.dtos.ProfessorDto;
import com.aimbra.sied.infra.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private ProfessorConverter converter;

    @Override
    public List<ProfessorDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
