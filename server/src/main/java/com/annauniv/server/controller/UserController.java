package com.annauniv.server.controller;

import com.annauniv.server.authentication.UserAccountService;
import com.annauniv.server.exception.UserAlreadyExistsException;
import com.annauniv.server.relational.UserAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserAccountService userAccountService;

    public UserController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_HEAD_OF_DEPARTMENT', 'ROLE_DEAN')")
    public ResponseEntity<UserDetails> getUser(@PathVariable("userId") Long userId) {
        try {
            return ResponseEntity.ok(userAccountService.loadUserByUsername(Long.toString(userId)));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping ("/save")
    public ResponseEntity<UserDetails> saveUser(@RequestBody UserAccount userAccount) {
        try {
            UserDetails addedUser = userAccountService.saveUser(userAccount);

            return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
