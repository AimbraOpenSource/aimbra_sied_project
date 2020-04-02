package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.CursoConverter;
import com.aimbra.sied.business.services.CursoService;
import com.aimbra.sied.domain.dtos.CursoDto;
import com.aimbra.sied.infra.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private CursoConverter converter;

    @Override
    public List<CursoDto> findAll() {
        return converter.toDtoList(repository.findAll())
;    }
}
