package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.services.UserService;
import com.aimbra.sied.security.sied.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Boolean existsUserByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
