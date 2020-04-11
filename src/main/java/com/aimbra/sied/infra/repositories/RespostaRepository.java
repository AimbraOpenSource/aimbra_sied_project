package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.RespostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaEntity, Integer> {
}
