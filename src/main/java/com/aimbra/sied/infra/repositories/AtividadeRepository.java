package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.entities.AtividadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<AtividadeEntity, Integer> {
}
