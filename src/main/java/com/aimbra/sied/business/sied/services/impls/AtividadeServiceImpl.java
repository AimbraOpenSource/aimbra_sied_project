package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AtividadeConverter;
import com.aimbra.sied.business.sied.services.AtividadeService;
import com.aimbra.sied.business.sied.services.AulaService;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import com.aimbra.sied.domain.sied.exceptions.AtividadeNotFoundException;
import com.aimbra.sied.infra.repositories.AtividadeRepository;
import com.aimbra.sied.infra.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private AtividadeConverter converter;

    @Qualifier("turmaServiceImpl")
    @Autowired
    private TurmaService turmaService;

    @Qualifier("aulaServiceImpl")
    @Autowired
    private AulaService aulaService;

    @Override
    public List<AtividadeDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public AtividadeDto insert(AtividadeDto dto) {
        TurmaDto turmaDto = turmaService.findById(dto.getAula().getTurma().getId());
        dto.getAula().setTurma(turmaDto);

        Integer orderAula = aulaService.findMaxOrderByTurmaId(dto.getAula().getTurma().getId());
        dto.getAula().setOrdem(++orderAula);

        dto.setCriadoEm(LocalDateTime.now());
        dto.setTitulo(dto.getAula().getTitulo());

        AtividadeEntity entity = converter.toEntity(dto);
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
