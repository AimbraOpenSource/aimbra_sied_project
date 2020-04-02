package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
}
