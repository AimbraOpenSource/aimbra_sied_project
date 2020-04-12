package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.services.UserService;
import com.aimbra.sied.security.sied.converters.UserConverter;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.exceptions.UserNotFoundException;
import com.aimbra.sied.security.sied.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserConverter converter;

    @Override
    public Boolean existsUserByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public UserDto findByUsername(String username) {
        return repository
                .findFirstByUsernameEquals(username)
                .map(u -> converter.toDto(u))
                .orElseThrow(() -> new UserNotFoundException("Usuario não encontrado por este nome de usuario"));
    }
}
