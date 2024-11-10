package com.atalar.software.user.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.atalar.software.user.model.Permission.ADMIN_CREATE;
import static com.atalar.software.user.model.Permission.ADMIN_DELETE;
import static com.atalar.software.user.model.Permission.ADMIN_READ;
import static com.atalar.software.user.model.Permission.ADMIN_UPDATE;

public enum Role {

    USER(Collections.emptySet()),
    ADMIN(Set.of(ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            ADMIN_CREATE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
