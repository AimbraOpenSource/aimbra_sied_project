package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.AlunoConverter;
import com.aimbra.sied.business.services.AlunoService;
import com.aimbra.sied.domain.dtos.AlunoDto;
import com.aimbra.sied.domain.entities.AlunoEntity;
import com.aimbra.sied.infra.repositories.AlunoRepository;
import com.aimbra.sied.security.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoConverter converter;

    @Override
    public List<AlunoDto> findAll() {
        return converter.toDtoList(repository.findAll());
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
}
