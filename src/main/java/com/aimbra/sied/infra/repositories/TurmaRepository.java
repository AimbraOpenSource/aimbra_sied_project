package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> {
    List<TurmaEntity> findAllByProfessor_User_Username(String username);
    Optional<TurmaEntity> findFirstByUuid(UUID uuid);
}
