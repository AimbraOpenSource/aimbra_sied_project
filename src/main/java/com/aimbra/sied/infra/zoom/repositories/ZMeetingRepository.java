package com.aimbra.sied.infra.zoom.repositories;

import com.aimbra.sied.domain.zoom.entities.ZMeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZMeetingRepository extends JpaRepository<ZMeetingEntity, Integer> {
}
