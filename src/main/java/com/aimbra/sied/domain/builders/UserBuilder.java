package com.aimbra.sied.domain.builders;

import com.aimbra.sied.security.entities.UserEntity;
import com.aimbra.sied.security.enums.UserRole;

import java.time.LocalDateTime;

public class UserBuilder {
    public static UserEntity create(Integer id, String username, String password, UserRole role, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lasAccessIn) {
        UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setUsername(username);
        entity.setPassoword(password);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        entity.setLastAccessIn(lasAccessIn);
        return entity;
    }
}
