package com.aimbra.sied.security.converters;

import com.aimbra.sied.business.converters.Converter;
import com.aimbra.sied.security.dtos.UserDto;
import com.aimbra.sied.security.entities.UserEntity;
import org.springframework.stereotype.Service;


@Service
public class UserConverter extends Converter<UserDto, UserEntity> {
    public UserConverter() {
        super(fromDto -> {
            var entity = new UserEntity();
            entity.setId(fromDto.getId());
            entity.setCreatedAt(fromDto.getCreatedAt());
            entity.setLastAccessIn(fromDto.getLastAccessIn());
            if (fromDto.getPassword() != null) {
                entity.setPassword(fromDto.getPassword());
            }
            entity.setEmail(fromDto.getEmail());
            entity.setRole(fromDto.getRole());
            entity.setUpdatedAt(fromDto.getUpdatedAt());
            entity.setUsername(fromDto.getUsername());
            return entity;
        }, fromEntity -> {
            var dto = new UserDto();
            dto.setId(fromEntity.getId());
            dto.setCreatedAt(fromEntity.getCreatedAt());
            dto.setLastAccessIn(fromEntity.getLastAccessIn());
            dto.setEmail(fromEntity.getEmail());
            if (fromEntity.getPassword() != null) {
                dto.setPassword(fromEntity.getPassword());
            }
            dto.setRole(fromEntity.getRole());
            dto.setUpdatedAt(fromEntity.getUpdatedAt());
            dto.setUsername(fromEntity.getUsername());
            return dto;
        });
    }
}
