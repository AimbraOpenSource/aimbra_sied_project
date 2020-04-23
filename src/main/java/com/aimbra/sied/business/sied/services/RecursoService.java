package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.security.sied.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecursoService {
    List<RecursoDto> findAll();
    List<RecursoDto> findAllByAulaIdByTipoExercicioProposto(Integer aulaId);
    RecursoDto findById(Integer id);
    void deleteById(Integer id);
    List<RecursoDto> findRespostaByUsernameAndAulaId(String username, Integer aulaId);
    void deleteByUserAndAula(UserDto user, AulaDto aula);

    List<RecursoDto> findByUserAndAula(UserDto user, AulaDto aula);
}
