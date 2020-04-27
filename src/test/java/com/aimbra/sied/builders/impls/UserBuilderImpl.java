package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.UserBuilder;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;

import java.time.LocalDateTime;

public class UserBuilderImpl implements UserBuilder {

    private UserDto userDto;

    public UserBuilderImpl(UserRole role) {
        userDto = new UserDto();
        userDto.setId(1);
        userDto.setRole(role);
        userDto.setPassword("123123123");
        userDto.setCreatedAt(LocalDateTime.now());
        userDto.setUpdatedAt(LocalDateTime.now());
        userDto.setLastAccessIn(LocalDateTime.now());
        userDto.setEmail("thiago@catolicamacae.com");
        userDto.setUsername("thiago.cunha");
    }

    @Override
    public UserDto build() {
        return userDto;
    }

    @Override
    public UserBuilder withIdNull() {
        userDto.setId(null);
        return this;
    }

    @Override
    public UserBuilder withUsernameNull() {
        userDto.setUsername(null);
        return this;
    }

    @Override
    public UserBuilder withPasswordNull() {
        userDto.setPassword(null);
        return this;
    }

    @Override
    public UserBuilder withRoleNull() {
        userDto.setRole(null);
        return this;
    }

    @Override
    public UserBuilder withUpdateAtNull() {
        userDto.setUpdatedAt(null);
        return this;
    }

    @Override
    public UserBuilder withCreatedAtNull() {
        userDto.setCreatedAt(null);
        return this;
    }

    @Override
    public UserBuilder withLastAccesInNull() {
        userDto.setUpdatedAt(null);
        return this;
    }

    @Override
    public UserBuilder withEmailNull() {
        userDto.setEmail(null);
        return this;
    }

}
