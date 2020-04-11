package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Integer> {
}
