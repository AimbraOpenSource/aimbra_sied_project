package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.ReuniaoConverter;
import com.aimbra.sied.business.services.ReuniaoService;
import com.aimbra.sied.domain.dtos.ReuniaoDto;
import com.aimbra.sied.infra.repositories.ReuniaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReuniaoServiceImpl implements ReuniaoService {

    @Autowired
    private ReuniaoRepository repository;

    @Autowired
    private ReuniaoConverter converter;

    @Override
    public List<ReuniaoDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
