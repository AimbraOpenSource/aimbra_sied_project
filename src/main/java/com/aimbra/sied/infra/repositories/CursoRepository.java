package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.entities.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
}
