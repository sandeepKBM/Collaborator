package com.annauniv.server.controller;

import com.annauniv.server.authentication.UserAccountService;
import com.annauniv.server.exception.UserAlreadyExistsException;
import com.annauniv.server.mail.MailConfiguration;
import com.annauniv.server.mail.Mailer;
import com.annauniv.server.relational.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static com.annauniv.server.authority.UserAccountDesignation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/users/save")
public class SaveController {
    private final UserAccountService userAccountService;
    private final MailConfiguration mailConfiguration;
    private final Mailer mailer;

    @Autowired
    public SaveController(UserAccountService userAccountService, MailConfiguration mailConfiguration, Mailer mailer) {
        this.userAccountService = userAccountService;
        this.mailConfiguration = mailConfiguration;
        this.mailer = mailer;
    }

    @PostMapping("/student")
    @PreAuthorize("hasAuthority('create:student')")
    public ResponseEntity<UserDetails> saveStudent(@RequestBody UserAccount userAccount) {
        if (userAccount.getDesignation() != STUDENT)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return saveUser(userAccount);
    }

    @PostMapping("/professor")
    @PreAuthorize("hasAuthority('create:professor')")
    public ResponseEntity<UserDetails> saveProfessor(@RequestBody UserAccount userAccount) {
        if (userAccount.getDesignation() != PROFESSOR)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return saveUser(userAccount);
    }

    @PostMapping("/hod")
    @PreAuthorize("hasAuthority('create:hod')")
    public ResponseEntity<UserDetails> saveHOD(@RequestBody UserAccount userAccount) {
        if (userAccount.getDesignation() != HOD)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return saveUser(userAccount);
    }

    @PostMapping("/dean")
    @PreAuthorize("hasAuthority('create:dean')")
    public ResponseEntity<UserDetails> saveDean(@RequestBody UserAccount userAccount) {
        if (userAccount.getDesignation() != DEAN)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return saveUser(userAccount);
    }

    private ResponseEntity<UserDetails> saveUser(UserAccount userAccount) {
        try {
            String recipient = userAccount.getEmail();

            String body = String.format(mailConfiguration.getBodyFormat(),
                    userAccount.getUsername(),
                    userAccount.getPassword()
            );

            UserDetails addedUser = userAccountService.saveUser(userAccount);

            mailer.sendMail(
                    recipient,
                    mailConfiguration.getSubject(),
                    body
            );

            return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
