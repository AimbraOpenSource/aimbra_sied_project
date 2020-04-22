package com.aimbra.sied.infra.zoom.repositories;

import com.aimbra.sied.domain.zoom.entities.ZAppConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZAppConfigurationRepository extends JpaRepository<ZAppConfigurationEntity, Integer> {
    Optional<ZAppConfigurationEntity> findFirstByUser_Username(String username);
}
