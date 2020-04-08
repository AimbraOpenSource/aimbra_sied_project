package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.dtos.AlunoDto;
import com.aimbra.sied.domain.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
    Optional<AlunoEntity> findFirstByUser_Username(String username);
}
