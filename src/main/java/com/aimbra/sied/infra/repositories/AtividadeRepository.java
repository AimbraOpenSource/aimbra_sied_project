package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtividadeRepository extends JpaRepository<AtividadeEntity, Integer> {
    Optional<AtividadeEntity> findByAula_Id(Integer id);
    void removeByAula_Id(Integer id);
}
