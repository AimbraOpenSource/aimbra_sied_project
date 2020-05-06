package com.aimbra.sied.domain.sied.builders;

import com.aimbra.sied.security.sied.entities.UserEntity;
import com.aimbra.sied.security.sied.enums.UserRole;

import java.time.LocalDateTime;

public class UserBuilder {
    public static UserEntity create(Integer id, String username, String email, String password, UserRole role, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lasAccessIn) {
        UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setEmail(email);
        entity.setRole(role);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        entity.setLastAccessIn(lasAccessIn);
        return entity;
    }
}
