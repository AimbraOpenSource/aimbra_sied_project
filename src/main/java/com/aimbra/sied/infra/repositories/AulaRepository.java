package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.AulaEntity;
import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Integer> {
    List<AulaEntity> findAllByTurma_IdAndTurma_Professor_User_Username(Integer id, String username);
}
