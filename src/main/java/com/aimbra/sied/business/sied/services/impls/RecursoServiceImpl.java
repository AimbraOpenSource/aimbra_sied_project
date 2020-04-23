package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AulaConverter;
import com.aimbra.sied.business.sied.converters.RecursoConverter;
import com.aimbra.sied.business.sied.services.AulaService;
import com.aimbra.sied.business.sied.services.RecursoService;
import com.aimbra.sied.business.sied.services.UserService;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.entities.RecursoEntity;
import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.infra.repositories.RecursoRepository;
import com.aimbra.sied.security.sied.converters.UserConverter;
import com.aimbra.sied.security.sied.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    private RecursoRepository repository;

    @Autowired
    private RecursoConverter converter;

    @Autowired
    private UserService userService;

    @Autowired
    private AulaService aulaService;

    @Override
    public List<RecursoDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    @Override
    public List<RecursoDto> findAllByAulaIdByTipoExercicioProposto(Integer aulaId) {
        return converter.toDtoList(repository.findAllByAula_IdAndTipo(aulaId, TipoRecurso.EXERCICIO_PROPOSTO));
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

    @Override
    public List<RecursoDto> findRespostaByUsernameAndAulaId(String username, Integer aulaId) {
        UserDto user = userService.findByUsername(username);
        AulaDto aula = aulaService.findById(aulaId);
        List<RecursoEntity> resp = repository.findAllByUserAndAula(new UserConverter().toEntity(user), new AulaConverter().toEntity(aula));
        return converter.toDtoList(resp);
    }

    @Override
    public void deleteByUserAndAula(UserDto user, AulaDto aula) {
        repository.deleteByUserAndAula(new UserConverter().toEntity(user), new AulaConverter().toEntity(aula));
    }

    @Override
    public List<RecursoDto> findByUserAndAula(UserDto user, AulaDto aula) {
        return converter.toDtoList(repository.findAllByUserAndAula(new UserConverter().toEntity(user), new AulaConverter().toEntity(aula)));
    }
}
