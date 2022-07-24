package com.annauniv.server.authentication;

import com.annauniv.server.exception.UserAlreadyExistsException;
import com.annauniv.server.relational.UserAccount;

import java.util.Optional;

public interface UserAccountDao {
    Optional<UserAccount> getUserById(Long id);

    UserAccount addUser(UserAccount user) throws UserAlreadyExistsException;
}
