package com.aimbra.sied.business.services;

import com.aimbra.sied.security.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Boolean existsUserByUsername(String username);
}
