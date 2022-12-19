package com.annauniv.server.mail;

public interface Mailer {
    void sendMail(String recipient, String subject, String body);
}
