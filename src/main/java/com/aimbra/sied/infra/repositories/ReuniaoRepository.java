package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.dtos.ReuniaoDto;
import com.aimbra.sied.domain.entities.ReuniaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReuniaoRepository extends JpaRepository<ReuniaoEntity, ReuniaoDto> {
}
