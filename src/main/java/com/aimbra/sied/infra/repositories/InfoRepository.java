package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.entities.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<InfoEntity, Integer> {
}
