package com.annauniv.server.authentication;

import com.annauniv.server.exception.UserAlreadyExistsException;
import com.annauniv.server.relational.UserAccount;
import com.annauniv.server.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserAccountDaoService implements UserAccountDao {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAccountDaoService(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Optional<UserAccount> getUserById(Long id) {
        return userAccountRepository.findById(id);
    }

    @Override
    @Transactional
    public UserAccount addUser(UserAccount user) throws UserAlreadyExistsException {
        Optional<UserAccount> checkUser = userAccountRepository.findById(user.getId());

        if (checkUser.isEmpty()) {
            String unencryptedPassword = user.getPassword();
            user.setPassword(passwordEncoder.encode(unencryptedPassword));
            return userAccountRepository.saveAndFlush(user);
        } else {
            throw new UserAlreadyExistsException(String.format("User with id %d already exists", user.getId()));
        }
    }
}
