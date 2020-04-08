package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
    Optional<ProfessorEntity> findFirstByUser_Username(String username);
}
