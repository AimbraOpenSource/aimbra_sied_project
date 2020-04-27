package com.aimbra.sied.builders.interfaces;

import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;

public interface UserBuilder {

    UserDto build();
    UserBuilder withIdNull();
    UserBuilder withUsernameNull();
    UserBuilder withPasswordNull();
    UserBuilder withRoleNull();
    UserBuilder withUpdateAtNull();
    UserBuilder withCreatedAtNull();
    UserBuilder withLastAccesInNull();
    UserBuilder withEmailNull();

}
