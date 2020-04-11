package com.aimbra.sied.security.sied.services;

import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.models.JwtUser;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@NoArgsConstructor
public class JwtUserFactory {

    public static JwtUser create(UserDto dto, List<GrantedAuthority> authorityList) {
        return new JwtUser(dto.getId(), dto.getUsername(), dto.getPassword(), authorityList);
    }

}
