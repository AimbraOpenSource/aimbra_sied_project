package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AulaConverter;
import com.aimbra.sied.business.sied.services.AulaService;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.exceptions.AulaNotAuthorizedException;
import com.aimbra.sied.infra.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository repository;

    @Autowired
    private AulaConverter converter;

    @Override
    public List<AulaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public AulaDto findById(Integer id) {
        return repository.findById(id).map(a -> converter.toDto(a)).orElseThrow(() -> new AulaNotAuthorizedException("Aula não encontrada pelo Id"));
    }

    @Override
    public List<AulaDto> findAllByTurmaIdAndUserLoggedIn(Integer turmaId, String username) {
        return converter.toDtoList(repository.findAllByTurma_IdAndTurma_Professor_User_Username(turmaId, username));
    }
}
