package com.example.fcss_01.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class DannyUser implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "READ"); //READ 권한을 가진 리스트를 반환
    }

    @Override
    public String getPassword() {
        return "12345";
    }

    @Override
    public String getUsername() {
        return "danny.kim";
    }

    @Override
    public boolean isAccountNonExpired() { //사용자의 계정이 만료되지 않았는지 여부를 반환
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() { //사용자의 계정이 잠기지 않았는지 여부를 반환
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() { //사용자의 자격 증명이 만료되지 않았는지 여부를 반환
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() { //사용자의 계정이 활성화되었는지 여부를 반환
        return UserDetails.super.isEnabled();
    }
}
