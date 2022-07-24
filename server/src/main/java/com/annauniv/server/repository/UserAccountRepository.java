package com.annauniv.server.repository;

import com.annauniv.server.relational.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {}
