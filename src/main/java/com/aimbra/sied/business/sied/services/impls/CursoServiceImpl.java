package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.CursoConverter;
import com.aimbra.sied.business.sied.services.CursoService;
import com.aimbra.sied.domain.sied.dtos.CursoDto;
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
