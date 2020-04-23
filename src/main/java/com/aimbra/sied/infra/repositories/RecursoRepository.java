package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.AulaEntity;
import com.aimbra.sied.domain.sied.entities.RecursoEntity;
import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.security.sied.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoEntity, Integer> {
    List<RecursoEntity> findAllByAula_IdAndTipo(Integer id, TipoRecurso tipo);

    @Query("select r from RecursoEntity r " +
            "   join UserEntity u on r.user = u " +
            "where u.username = :username and r.id = :aulaId")
    List<RecursoEntity> findRespostasByUsername(@Param("username") String username, @Param("aulaId") Integer aulaId);

    List<RecursoEntity> findAllByUserAndAula(UserEntity user, AulaEntity aula);

    void deleteByUserAndAula(UserEntity user, AulaEntity aula);
}
