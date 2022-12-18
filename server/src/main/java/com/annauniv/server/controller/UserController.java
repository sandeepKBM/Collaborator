package com.annauniv.server.controller;

import com.annauniv.server.authentication.UserAccountService;
import com.annauniv.server.exception.UserAlreadyExistsException;
import com.annauniv.server.relational.UserAccount;
import com.annauniv.server.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserAccountService userAccountService;

    private final UserAccountRepository repository;

    @Autowired
    public UserController(UserAccountService userAccountService, UserAccountRepository repository) {
        this.userAccountService = userAccountService;
        this.repository = repository;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('view:details')")
    public ResponseEntity<UserDetails> getUser(@PathVariable("userId") String userId) {
        try {
            return ResponseEntity.ok(userAccountService.loadUserByUsername(userId));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAccount>> users() {
        //TODO: Delete this function
        return ResponseEntity.ok(repository.findAll());
    }
}
