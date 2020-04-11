package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> {
}
