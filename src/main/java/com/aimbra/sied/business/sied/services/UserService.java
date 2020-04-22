package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.security.sied.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Boolean existsUserByUsername(String username);
    boolean existsUserByEmail(String email);
    UserDto findByUsername(String username);
}
