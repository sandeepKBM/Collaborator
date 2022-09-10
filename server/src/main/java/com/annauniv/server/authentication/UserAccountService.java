package com.annauniv.server.authentication;

import com.annauniv.server.exception.UserAlreadyExistsException;
import com.annauniv.server.relational.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements UserAccountDetails {

    private final UserAccountDao userAccountDao;

    @Autowired
    public UserAccountService(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return userAccountDao.getUserById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("No user with id %s", id)));
    }

    @Override
    public UserAccount saveUser(UserAccount user) throws UserAlreadyExistsException {
        return userAccountDao.addUser(user);
    }
}
