package com.myspring.bpmsystem.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, MANAGER, ACCOUNTANT, SECURITY;

    @Override
    public String getAuthority() {
        return name();
    }
}