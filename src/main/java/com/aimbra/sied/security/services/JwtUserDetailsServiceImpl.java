package com.aimbra.sied.security.services;

import com.aimbra.sied.security.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userResponse = authService.findByUsername(username);
        String permission = "ROLE_" + userResponse.getRole().toString().toUpperCase();
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(permission);
        return JwtUserFactory.create(userResponse, authorityList);
    }
}
