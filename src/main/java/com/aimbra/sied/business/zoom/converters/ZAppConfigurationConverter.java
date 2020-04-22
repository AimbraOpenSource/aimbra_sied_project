package com.aimbra.sied.business.zoom.converters;

import com.aimbra.sied.business.sied.converters.Converter;
import com.aimbra.sied.domain.zoom.dtos.ZAppConfigurationDto;
import com.aimbra.sied.domain.zoom.entities.ZAppConfigurationEntity;
import com.aimbra.sied.security.sied.converters.UserConverter;
import org.springframework.stereotype.Service;

@Service
public class ZAppConfigurationConverter extends Converter<ZAppConfigurationDto, ZAppConfigurationEntity> {
    public ZAppConfigurationConverter() {
        super(fromDto -> {
            var entity = new ZAppConfigurationEntity();
            entity.setId(fromDto.getId());
            entity.setApiKey(fromDto.getApiKey());
            entity.setApiSecret(fromDto.getApiSecret());
            entity.setExpiredAt(fromDto.getExpiredAt());
            entity.setImChatHistoryToken(fromDto.getImChatHistoryToken());
            entity.setJwtToken(fromDto.getJwtToken());
            entity.setUser(new UserConverter().toEntity(fromDto.getUser()));
            return entity;
        }, fromEntity -> {
            var dto = new ZAppConfigurationDto();
            dto.setId(fromEntity.getId());
            dto.setApiKey(fromEntity.getApiKey());
            dto.setApiSecret(fromEntity.getApiSecret());
            dto.setExpiredAt(fromEntity.getExpiredAt());
            dto.setImChatHistoryToken(fromEntity.getImChatHistoryToken());
            dto.setJwtToken(fromEntity.getJwtToken());
            dto.setUser(new UserConverter().toDto(fromEntity.getUser()));
            return dto;
        });
    }
}
