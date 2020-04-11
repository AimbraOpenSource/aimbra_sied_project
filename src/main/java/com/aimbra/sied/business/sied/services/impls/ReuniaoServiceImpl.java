package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.ReuniaoConverter;
import com.aimbra.sied.business.sied.services.ReuniaoService;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
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
