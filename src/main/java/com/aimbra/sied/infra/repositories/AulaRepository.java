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
    /**
     * TODO: O método abaixo deve organizar por data de lançamento as aulas. É preciso criar a entidade data de lançamento
     */
    List<AulaEntity> findAllByTurma_IdAndTurma_Professor_User_Username(Integer id, String username);
    List<AulaEntity> findAllByTurma_Id(Integer id);
}
