package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoEntity, Integer> {
    List<RecursoEntity> findAllByAula_Id(Integer id);
}
