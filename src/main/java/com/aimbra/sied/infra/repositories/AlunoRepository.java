package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
}
