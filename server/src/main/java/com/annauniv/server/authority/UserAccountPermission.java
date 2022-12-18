package com.annauniv.server.authority;

public enum UserAccountPermission {
    CREATE_STUDENT("create:student"),
    CREATE_PROFESSOR("create:professor"),
    CREATE_HOD("create:hod"),
    CREATE_DEAN("create:dean"),
    VIEW_DETAILS("view:details");
    private final String permission;

    UserAccountPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
