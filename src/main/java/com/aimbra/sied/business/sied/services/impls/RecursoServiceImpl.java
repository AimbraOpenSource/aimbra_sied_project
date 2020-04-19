package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.RecursoConverter;
import com.aimbra.sied.business.sied.services.RecursoService;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.infra.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    private RecursoRepository repository;

    @Autowired
    private RecursoConverter converter;

    @Override
    public List<RecursoDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public List<RecursoDto> findAllByAulaId(Integer aulaId) {
        return converter.toDtoList(repository.findAllByAula_Id(aulaId));
    }

    @Override
    public RecursoDto findById(Integer id) {
        return repository.findById(id)
                .map(r -> converter.toDto(r))
                .orElseThrow(() -> new BadRequestException("Não foi possivel achar o arquivo com este Id"));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
