package com.example.fcss_01.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SimpleUser implements UserDetails { // 이거는 데이터를 받아와서 처리

    private final String username;
    private final String password;

    SimpleUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "READ");//READ 권한을 가진 리스트를 반환
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {//사용자의 계정이 만료되지 않았는지 여부를 반환
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {//사용자의 계정이 잠기지 않았는지 여부를 반환
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {//사용자의 자격 증명이 만료되지 않았는지 여부를 반환
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {//사용자의 계정이 활성화되었는지 여부를 반환
        return UserDetails.super.isEnabled();
    }
}
