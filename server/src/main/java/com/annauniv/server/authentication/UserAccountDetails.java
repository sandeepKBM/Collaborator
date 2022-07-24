package com.annauniv.server.authentication;

import com.annauniv.server.exception.UserAlreadyExistsException;
import com.annauniv.server.relational.UserAccount;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAccountDetails extends UserDetailsService {

    UserAccount saveUser(UserAccount user) throws UserAlreadyExistsException;
}
