package com.aimbra.sied.builders;

import com.aimbra.sied.security.sied.dtos.UserDto;

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
