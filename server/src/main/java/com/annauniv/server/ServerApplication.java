package com.annauniv.server;

import com.annauniv.server.authority.UserAccountDesignation;
import com.annauniv.server.model.DiscussionText;
import com.annauniv.server.relational.UserAccount;
import com.annauniv.server.repository.DiscussionTextJpaRepository;
import com.annauniv.server.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.sql.CallableStatement;
import java.sql.Timestamp;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ServerApplication implements CommandLineRunner {
    @Autowired
    private UserAccountRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("start");
        UserAccount u1 = new UserAccount("1","vishnu","vishnu", UserAccountDesignation.STUDENT);

        repository.save(u1);
        System.out.println("finished CMD Line Runner");
    }

}
