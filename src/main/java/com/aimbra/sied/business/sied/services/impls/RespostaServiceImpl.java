package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.RespostaConverter;
import com.aimbra.sied.business.sied.services.RespostaService;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import com.aimbra.sied.infra.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private RespostaConverter converter;

    @Override
    public List<RespostaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }
}
