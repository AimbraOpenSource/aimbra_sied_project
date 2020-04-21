package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.TurmaConverter;
import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.business.sied.services.UserService;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaAlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import com.aimbra.sied.domain.sied.enums.SIEDKeyType;
import com.aimbra.sied.domain.sied.exceptions.TurmaNotAuthorizedException;
import com.aimbra.sied.domain.sied.exceptions.TurmaNotFoundException;
import com.aimbra.sied.domain.sied.utils.Utils;
import com.aimbra.sied.infra.repositories.TurmaRepository;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private TurmaConverter converter;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService alunoService;

    @Override
    public List<TurmaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public TurmaDto findById(Integer id) {
        return repository.findById(id).map(t -> converter.toDto(t)).orElseThrow(() -> new TurmaNotFoundException("Turma não encontrada pelo Id"));
    }

    @Override
    public List<TurmaDto> findAllByProfessorUsername(String username) {
        return converter.toDtoList(repository.findAllByProfessor_User_Username(username));
    }

    @Override
    public List<TurmaAlunoDto> findAllByAlunoUsername(String username) {
        return alunoService.findAllTurmasByUsername(username);
    }

    @Override
    public TurmaDto create(TurmaDto turmaDto) {
        turmaDto.setSenha(Utils.getKey(SIEDKeyType.TURMA));
        return converter.toDto(repository.save(converter.toEntity(turmaDto)));
    }

    @Override
    public void deleteAll(List<TurmaDto> turmas) {
        turmas.forEach(t -> repository.deleteById(t.getId()));
    }

    @Override
    public TurmaDto findByUuid(UUID uuid) {
        return repository.findFirstByUuid(uuid).map(t -> converter.toDto(t)).orElseThrow(() -> new TurmaNotFoundException("Turma não encontrada pelo UUID"));
    }

}
