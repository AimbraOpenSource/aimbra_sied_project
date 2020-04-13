package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AtividadeConverter;
import com.aimbra.sied.business.sied.services.AtividadeService;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import com.aimbra.sied.domain.sied.exceptions.AtividadeNotFoundException;
import com.aimbra.sied.infra.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private AtividadeConverter converter;

    @Override
    public List<AtividadeDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public AtividadeDto insert(AtividadeDto dto) {
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
}
