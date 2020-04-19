package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AlunoConverter;
import com.aimbra.sied.business.sied.converters.TurmaAlunoConverter;
import com.aimbra.sied.business.sied.converters.TurmaConverter;
import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaAlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.AlunoEntity;
import com.aimbra.sied.domain.sied.exceptions.TurmaNotAuthorizedException;
import com.aimbra.sied.domain.sied.exceptions.TurmaNotFoundException;
import com.aimbra.sied.infra.repositories.AlunoRepository;
import com.aimbra.sied.security.sied.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoConverter converter;

    @Autowired
    private TurmaAlunoConverter turmaAlunoConverter;

    @Override
    public List<AlunoDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public List<TurmaAlunoDto> findAllTurmasByUsername(String username) {
        return repository
                .findFirstByUser_Username(username)
                .map(a -> turmaAlunoConverter.toDtoList(a.getTurmas()))
                .orElseThrow(() -> new TurmaNotFoundException("turma não encontrado pelo usuário ativo."));
    }

    @Override
    public AlunoDto findByUsername(String username) {
        Optional<AlunoEntity> alunoResponse = repository.findFirstByUser_Username(username);
        return alunoResponse
                .map(a -> converter.toDto(a))
                .orElseThrow(() -> new UserNotFoundException("Aluno não encontrado com este nome de usuário"));
    }

    @Override
    public AlunoDto save(AlunoDto dto) {
        AlunoEntity alunoEntity = converter.toEntity(dto);
        return converter.toDto(repository.save(alunoEntity));
    }

    /**
     * TODO: Fazer depois esse sql para retornar se aluno existe em alguma turma
     * @param uuid
     * @param username
     * @return
     */
    @Override
    public Boolean existsOnTurmaUuidAndUsername(UUID uuid, String username) {
        return null;
    }
}
