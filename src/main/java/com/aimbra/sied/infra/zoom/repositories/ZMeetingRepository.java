package com.aimbra.sied.infra.zoom.repositories;

import com.aimbra.sied.domain.zoom.entities.ZMeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZMeetingRepository extends JpaRepository<ZMeetingEntity, Integer> {

    @Query(value = "select * from zoom.meetings where aula_id = :aulaId", nativeQuery  = true)
    List<ZMeetingEntity> findAllByAulaId(@Param("aulaId") Integer id);
}
