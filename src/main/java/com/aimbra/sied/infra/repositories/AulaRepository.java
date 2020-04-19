package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.AulaEntity;
import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Integer> {
    List<AulaEntity> findAllByTurma_IdAndTurma_Professor_User_UsernameOrderByOrdem(Integer id, String username);

    @Query(value = "select max(a.ordem) from aulas a where turma_id = :turmaId", nativeQuery = true)
    Optional<Integer> findMaxOrderByTurmaId(@Param("turmaId") Integer turmaId);
}
