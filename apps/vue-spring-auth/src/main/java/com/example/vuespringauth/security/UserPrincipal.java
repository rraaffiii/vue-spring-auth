package com.example.vuespringauth.security;

import com.example.vuespringauth.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UserPrincipal implements UserDetails {
    transient private User user;
    private Long id;
    private String username;
    transient private String password;
    private Set<GrantedAuthority> authorities;

    public UserPrincipal() {
    }

    public UserPrincipal(User user, Long id, String username, String password, Set<GrantedAuthority> authorities) {
        this.user = user;
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public UserPrincipal(Long id, String username, Set<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.authorities = authorities;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
