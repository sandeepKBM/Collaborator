package com.annauniv.server.controller;

import com.annauniv.server.model.Newsletter;
import com.annauniv.server.repository.NewsletterJpaRepository;
import com.annauniv.server.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("api/discussions")
public class NewsletterController {
    @Autowired
    MongoOperations mongoOperations;
    Date date = new Date();

    // getting the object of the Timestamp class
    Timestamp instant = new Timestamp(date.getTime());
    @Autowired
    private final NewsletterService newsletterService;
    private final NewsletterJpaRepository newsletterJpaRepository;


    @Autowired
    public NewsletterController(NewsletterService newsletterService, NewsletterJpaRepository newsletterJpaRepository) {
        this.newsletterService = newsletterService;
        this.newsletterJpaRepository = newsletterJpaRepository;
    }

    @GetMapping("/listAll")
    public @ResponseBody List<Newsletter> newsLetterList(){

        return newsletterService.listAllNewsletter();
    }

    @PostMapping("/insertNewsletter")
    public void insertNewsletter(@RequestParam Long id ,@RequestParam String text,@RequestParam String type,@RequestParam String moreInfo, @RequestParam String link){
        newsletterService.insertNewsletter(id, text, type, moreInfo, link);
    }
}
