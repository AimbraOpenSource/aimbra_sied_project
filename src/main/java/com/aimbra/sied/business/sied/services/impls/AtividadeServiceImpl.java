package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AtividadeConverter;
import com.aimbra.sied.business.sied.converters.AulaConverter;
import com.aimbra.sied.business.sied.services.AtividadeService;
import com.aimbra.sied.business.sied.services.AulaService;
import com.aimbra.sied.business.sied.services.ReuniaoService;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.business.zoom.services.ZMeetingService;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import com.aimbra.sied.domain.sied.entities.AulaEntity;
import com.aimbra.sied.domain.sied.exceptions.AtividadeNotFoundException;
import com.aimbra.sied.domain.zoom.builders.MeetingBuild;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingResponseDto;
import com.aimbra.sied.infra.repositories.AtividadeRepository;
import com.aimbra.sied.infra.repositories.AulaRepository;
import com.aimbra.sied.infra.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtividadeServiceImpl implements AtividadeService, Serializable {

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private AtividadeConverter converter;

    @Qualifier("turmaServiceImpl")
    @Autowired
    private TurmaService turmaService;

    @Qualifier("ZMeetingServiceImpl")
    @Autowired
    private ZMeetingService meetingService;

    @Override
    public List<AtividadeDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public AtividadeDto insert(AtividadeDto atividadeDto) {
        boolean temAulaAuVivo = atividadeDto.getConfiguracao().getTemAulaAoVivo();
        if (temAulaAuVivo) {
            ZMeetingResponseDto zMeetingResponseDto = meetingService.create(MeetingBuild.builderFromAulaDto(atividadeDto.getAula()));
            atividadeDto.getReuniao().setLink(zMeetingResponseDto.getJoinUrl());
        }

        AulaEntity aulaEntity = aulaRepository.save(new AulaConverter().toEntity(atividadeDto.getAula()));
        atividadeDto.setAula(new AulaConverter().toDto(aulaEntity));

        AtividadeEntity entity = converter.toEntity(atividadeDto);
        return converter.toDto(repository.save(entity));
    }

    @Override
    public AtividadeDto findById(Integer id) {
        return repository.findById(id).map(a -> converter.toDto(a)).orElseThrow(() -> new AtividadeNotFoundException("Não fo encontrado esta atividade"));
    }

    @Override
    public AtividadeDto findByAulaId(Integer id) {
        return repository.findByAula_Id(id).map(a -> converter.toDto(a)).orElseThrow(() -> new AtividadeNotFoundException("Não fo encontrado esta atividade"));
    }

    @Override
    public void deleteByAulaId(Integer aulaId) {
        repository.removeByAula_Id(aulaId);
    }
}
