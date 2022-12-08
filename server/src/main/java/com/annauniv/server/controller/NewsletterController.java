package com.annauniv.server.controller;

import com.annauniv.server.authority.UserAccountDesignation;
import com.annauniv.server.model.Newsletter;
import com.annauniv.server.repository.NewsletterJpaRepository;
import com.annauniv.server.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("api/news")
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

    @GetMapping("/receiveNews")
    public void getData(){
        String uri = "http://localhost:8000/getNews";
        String ans = newsletterService.fetchData(uri);
        System.out.println(ans);
    }

    //    @GetMapping("/tester")
//    public void tester(@Re){
//
//    }
    /*@GetMapping("/alltext")
    public List<DiscussionText> getAllDiscussionText(){
        return discussionIndexService.getAllDiscussionText();
    }

    @GetMapping("/alldisstext")
    public List<DiscussionText> getAllDiscussionText(@RequestParam Long disscussionID){

        return discussionIndexService.getUserDiscussionText(disscussionID);
    }

    @PostMapping("/insertDiscusssion")
    public void insertDiscussion(@RequestParam Long userid ,@RequestParam Long discussionId,@RequestParam String discussionName,@RequestParam String description){
        discussionIndexService.insertDiscussion(discussionId,userid,discussionName,description,UserAccountDesignation.PROFESSOR);
    }*/


}
