package com.aimbra.sied.business.zoom.converters;

import com.aimbra.sied.business.sied.converters.AulaConverter;
import com.aimbra.sied.business.sied.converters.Converter;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingResponseDto;
import com.aimbra.sied.domain.zoom.entities.ZMeetingEntity;
import org.springframework.stereotype.Service;

@Service
public class ZMeetingConverter extends Converter<ZMeetingResponseDto, ZMeetingEntity> {
    public ZMeetingConverter() {
        super(fromDto -> {
            var entity = new ZMeetingEntity();
            entity.setId(fromDto.getId());
            entity.setUuid(fromDto.getUuid());
            entity.setHostId(fromDto.getHostId());
            entity.setTopic(fromDto.getTopic());
            entity.setType(fromDto.getType());
            entity.setStatus(fromDto.getStatus());
            entity.setStartTime(fromDto.getStartTime());
            entity.setDuration(fromDto.getDuration());
            entity.setTimezone(fromDto.getTimezone());
            entity.setAgenda(fromDto.getAgenda());
            entity.setCreated_at(fromDto.getCreated_at());
            entity.setStartUrl(fromDto.getStartUrl());
            entity.setJoinUrl(fromDto.getJoinUrl());
            entity.setPmi(fromDto.getPmi());
            return entity;
        }, fromEntity -> {
            var dto = new ZMeetingResponseDto();
            dto.setId(fromEntity.getId());
            dto.setUuid(fromEntity.getUuid());
            dto.setHostId(fromEntity.getHostId());
            dto.setTopic(fromEntity.getTopic());
            dto.setType(fromEntity.getType());
            dto.setStatus(fromEntity.getStatus());
            dto.setStartTime(fromEntity.getStartTime());
            dto.setDuration(fromEntity.getDuration());
            dto.setTimezone(fromEntity.getTimezone());
            dto.setAgenda(fromEntity.getAgenda());
            dto.setCreated_at(fromEntity.getCreated_at());
            dto.setStartUrl(fromEntity.getStartUrl());
            dto.setJoinUrl(fromEntity.getJoinUrl());
            dto.setPmi(fromEntity.getPmi());
            return dto;
        });
    }
}
