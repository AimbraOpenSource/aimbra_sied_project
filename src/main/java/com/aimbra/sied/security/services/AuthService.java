package com.aimbra.sied.security.services;

import com.aimbra.sied.domain.builders.UserBuilder;
import com.aimbra.sied.domain.utils.Utils;
import com.aimbra.sied.security.converters.UserConverter;
import com.aimbra.sied.security.dtos.JwtPayloadDto;
import com.aimbra.sied.security.dtos.UserDto;
import com.aimbra.sied.security.entities.UserEntity;
import com.aimbra.sied.security.exceptions.UserNotFoundException;
import com.aimbra.sied.security.repositories.UserRepository;
import com.aimbra.sied.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserConverter converter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Qualifier("jwtUserDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    public UserDto findByUsername(String username) {
        Optional<UserEntity> response = repository.findFirstByUsernameEquals(username);
        return response.map(userEntity -> converter.toDto(userEntity)).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }

    public JwtPayloadDto login(JwtPayloadDto payloadDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        payloadDto.getUsername(),
                        payloadDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userDetailsService.loadUserByUsername(payloadDto.getUsername());
        String token = jwtTokenUtil.getToken(userDetails);

        payloadDto = new JwtPayloadDto();
        payloadDto.setUser(findByUsername(userDetails.getUsername()));
        payloadDto.setToken(token);
        payloadDto.setPassword(null);
        payloadDto.setUsername(payloadDto.getUser().getUsername());
        payloadDto.getUser().setPassword(null);

        return payloadDto;
    }

    public UserDto register(UserDto user) {
        UserEntity entity = UserBuilder.create(
                user.getId(),
                user.getUsername(),
                Utils.encodePassoword(user.getPassword()),
                user.getRole(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        return converter.toDto(repository.save(entity));
    }
}
