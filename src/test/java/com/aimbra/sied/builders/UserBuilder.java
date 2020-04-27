package com.aimbra.sied.builders;

import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;

import java.time.LocalDateTime;

public class UserBuilder {

    private UserDto userDto;

    private UserBuilder() { }

    public static UserBuilder init(UserRole userRole) {
        UserBuilder ub = new UserBuilder();
        ub.userDto = new UserDto();
        ub.userDto.setId(1);
        ub.userDto.setRole(userRole);
        ub.userDto.setPassword("123123123");
        ub.userDto.setCreatedAt(LocalDateTime.now());
        ub.userDto.setUpdatedAt(LocalDateTime.now());
        ub.userDto.setLastAccessIn(LocalDateTime.now());
        ub.userDto.setEmail("thiago@catolicamacae.com");
        ub.userDto.setUsername("thiago.cunha");
        return ub;
    }

    public UserDto build() {
        return userDto;
    }

    public UserBuilder withIdNull() {
        userDto.setId(null);
        return this;
    }

    public UserBuilder withUsernameNull() {
        userDto.setUsername(null);
        return this;
    }

    public UserBuilder withPasswordNull() {
        userDto.setPassword(null);
        return this;
    }

    public UserBuilder withRoleNull() {
        userDto.setRole(null);
        return this;
    }

    public UserBuilder withUpdateAtNull() {
        userDto.setUpdatedAt(null);
        return this;
    }

    public UserBuilder withCreatedAtNull() {
        userDto.setCreatedAt(null);
        return this;
    }

    public UserBuilder withLastAccesInNull() {
        userDto.setUpdatedAt(null);
        return this;
    }

    public UserBuilder withEmailNull() {
        userDto.setEmail(null);
        return this;
    }

}
