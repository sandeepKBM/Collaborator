package com.annauniv.server.service;

import com.annauniv.server.authority.UserAccountDesignation;
import com.annauniv.server.model.Newsletter;
import com.annauniv.server.repository.NewsletterJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class NewsletterService {
    @Autowired
    MongoOperations mongoOperations;
    @Autowired
    MongoTemplate mongoTemplate;

    Timestamp instant= Timestamp.from(Instant.now());
    private final NewsletterJpaRepository newsletterJpaRepository;

    @Autowired
    public NewsletterService(NewsletterJpaRepository newsletterJpaRepository) {
        this.newsletterJpaRepository = newsletterJpaRepository;
    }

    public List<Newsletter> listAllNewsletter(){
        return newsletterJpaRepository.findAll();
    }

    public void insertNewsletter(Long id , String text, String type, String moreInfo, String link){
        Newsletter val = new Newsletter(id, text, type, moreInfo, link);
        newsletterJpaRepository.save(val);
    }
}
