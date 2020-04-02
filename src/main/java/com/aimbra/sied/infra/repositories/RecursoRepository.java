package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.entities.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoEntity, Integer> {
}
