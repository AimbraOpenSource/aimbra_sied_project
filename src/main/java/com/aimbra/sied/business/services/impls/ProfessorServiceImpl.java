package com.aimbra.sied.business.services.impls;

import com.aimbra.sied.business.converters.ProfessorConverter;
import com.aimbra.sied.business.services.ProfessorService;
import com.aimbra.sied.domain.dtos.ProfessorDto;
import com.aimbra.sied.domain.entities.ProfessorEntity;
import com.aimbra.sied.infra.repositories.ProfessorRepository;
import com.aimbra.sied.security.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private ProfessorConverter converter;

    @Override
    public List<ProfessorDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public ProfessorDto save(ProfessorDto dto) {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    @Override
    public ProfessorDto findByUsername(String username) {
        Optional<ProfessorEntity> professorResponse = repository.findFirstByUser_Username(username);
        return professorResponse
                .map(r -> converter.toDto(r))
                .orElseThrow(() -> new UserNotFoundException("Professor não encontrado com este nome de usuário"));
    }
}
