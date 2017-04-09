package com.elys.jwt.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Elys Javier Rivero
 *
 * @since 09/04/17
 */
public class AuthenticatedUser implements UserDetails {

    private long idUser;

    public AuthenticatedUser(long idUser) {
        this.idUser = idUser;
    }

    public AuthenticatedUser() {
    }

    public long getIdUser() {
        return idUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
