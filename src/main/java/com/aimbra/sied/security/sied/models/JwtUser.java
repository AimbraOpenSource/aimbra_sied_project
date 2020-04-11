package com.aimbra.sied.security.sied.models;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUser implements UserDetails {

    private static final long serialVersionUID = -8687607334671302981L;

    @Getter
    private final Integer id;
    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorityList;

    @Getter
    private User user;

    public JwtUser(Integer id, String username, String password, List<GrantedAuthority> authorityList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorityList = authorityList;
        setUser();
    }

    void setUser() {
        this.user = new User(username, password, authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
