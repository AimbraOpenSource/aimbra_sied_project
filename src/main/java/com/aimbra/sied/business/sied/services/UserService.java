package com.aimbra.sied.business.sied.services;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Boolean existsUserByUsername(String username);
    boolean existsUserByEmail(String email);
}
