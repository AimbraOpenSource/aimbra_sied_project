package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AulaConverter;
import com.aimbra.sied.business.sied.services.AtividadeService;
import com.aimbra.sied.business.sied.services.AulaService;
import com.aimbra.sied.business.zoom.services.ZMeetingService;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.exceptions.AulaNotAuthorizedException;
import com.aimbra.sied.infra.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository repository;

    @Autowired
    private AulaConverter converter;

    @Qualifier("ZMeetingServiceImpl")
    @Autowired
    private ZMeetingService zMeetingService;

    @Qualifier(value = "atividadeServiceImpl")
    @Autowired
    private AtividadeService atividadeService;

    @Override
    public List<AulaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public AulaDto findById(Integer id) {
        return repository.findById(id)
                .map(a -> converter.toDto(a))
                .orElseThrow(() -> new AulaNotAuthorizedException("Aula não encontrada pelo Id"));
    }

    @Override
    public List<AulaDto> findAllByTurmaIdAndProfessorUserLoggedIn(Integer turmaId, String username) {
        return converter.toDtoList(repository.findAllByTurma_IdAndTurma_Professor_User_Username(turmaId, username));
    }

    @Override
    public Integer findMaxOrderByTurmaId(Integer turmaId) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        zMeetingService.deleteByAulaId(id);
        atividadeService.deleteByAulaId(id);
        repository.deleteById(id);
    }

    @Override
    public List<AulaDto> findAllByTurmaId(Integer turmaId) {
        return converter.toDtoList(repository.findAllByTurma_Id(turmaId));
    }


}
