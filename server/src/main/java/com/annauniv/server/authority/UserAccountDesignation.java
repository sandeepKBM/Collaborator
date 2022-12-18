package com.annauniv.server.authority;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static com.annauniv.server.authority.UserAccountPermission.*;

public enum UserAccountDesignation {
    STUDENT,
    PROFESSOR(VIEW_DETAILS),
    HOD(CREATE_STUDENT, CREATE_PROFESSOR, VIEW_DETAILS),
    DEAN(CREATE_STUDENT, CREATE_PROFESSOR, CREATE_HOD, CREATE_DEAN, VIEW_DETAILS);


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
