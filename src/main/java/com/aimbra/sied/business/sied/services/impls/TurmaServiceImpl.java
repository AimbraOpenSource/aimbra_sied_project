package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.TurmaConverter;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.enums.SIEDKeyType;
import com.aimbra.sied.domain.sied.utils.Utils;
import com.aimbra.sied.infra.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private TurmaConverter converter;

    @Override
    public List<TurmaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public List<TurmaDto> findAllByUsername(String username) {
        return converter.toDtoList(repository.findAllByProfessor_User_Username(username));
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
}
