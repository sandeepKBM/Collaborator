package com.annauniv.server.authority;

public enum UserAccountPermission {
    ;
    private final String permission;

    UserAccountPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
