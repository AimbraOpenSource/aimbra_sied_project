package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.ReuniaoConverter;
import com.aimbra.sied.business.sied.services.ReuniaoService;
import com.aimbra.sied.business.zoom.services.ZMeetingService;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import com.aimbra.sied.domain.sied.entities.ReuniaoEntity;
import com.aimbra.sied.domain.zoom.builders.MeetingBuild;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingResponseDto;
import com.aimbra.sied.infra.repositories.ReuniaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Override
    public ReuniaoDto saveFromAula(AulaDto aulaDto) {

        ReuniaoEntity entity = repository.save(converter.toEntity(aulaDto.getReuniao()));
        return converter.toDto(entity);
    }


}
