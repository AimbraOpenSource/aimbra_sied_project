package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.RespostaConverter;
import com.aimbra.sied.business.services.RespostaService;
import com.aimbra.sied.domain.dtos.RespostaDto;
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
