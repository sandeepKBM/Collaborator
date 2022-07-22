package com.annauniv.server.service;

import com.annauniv.server.model.Role;
import com.annauniv.server.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();

}
