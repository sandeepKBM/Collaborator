package com.annauniv.server.authority;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum UserAccountDesignation {
    STUDENT,
    PROFESSOR,
    HOD,
    DEAN;

    private final Set<UserAccountPermission> permissions;

    UserAccountDesignation(UserAccountPermission ... permissionInput) {
        Set<UserAccountPermission> permissions = Sets.newHashSet();
        permissions.addAll(Arrays.asList(permissionInput));

        this.permissions = permissions;
    }

    public Set<UserAccountPermission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
