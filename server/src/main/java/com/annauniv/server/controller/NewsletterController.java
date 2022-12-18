//package com.annauniv.server.controller;
//
//import com.annauniv.server.repository.NewsletterMongoRepository;
//import com.annauniv.server.service.NewsletterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Timestamp;
//import java.util.Date;
//
//@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
//@RequestMapping("api/news")
//public class NewsletterController {
//
//    @Autowired
//    MongoOperations mongoOperations;
//    Date date = new Date();
//
//    // getting the object of the Timestamp class
//    Timestamp instant = new Timestamp(date.getTime());
//    @Autowired
//    private final NewsletterService newsletterService;
//
//    private final NewsletterMongoRepository newsletterMongoRepository;
//
//    @Autowired
//    public NewsletterController(NewsletterService newsletterService, NewsletterMongoRepository newsletterMongoRepository) {
//        this.newsletterService = newsletterService;
//        this.newsletterMongoRepository = newsletterMongoRepository;
//    }
//
//    @GetMapping("/receiveNews")
//    public void getData(){
//        String uri = "http://127.0.0.1:8000/getNews";
//        String ans = newsletterService.fetchData(uri);
//        System.out.println(ans);
//    }
//
//    //    @GetMapping("/tester")
////    public void tester(@Re){
////
////    }
//    /*@GetMapping("/alltext")
//    public List<DiscussionText> getAllDiscussionText(){
//        return discussionIndexService.getAllDiscussionText();
//    }
//
//    @GetMapping("/alldisstext")
//    public List<DiscussionText> getAllDiscussionText(@RequestParam Long disscussionID){
//
//        return discussionIndexService.getUserDiscussionText(disscussionID);
//    }
//
//    @PostMapping("/insertDiscusssion")
//    public void insertDiscussion(@RequestParam Long userid ,@RequestParam Long discussionId,@RequestParam String discussionName,@RequestParam String description){
//        discussionIndexService.insertDiscussion(discussionId,userid,discussionName,description,UserAccountDesignation.PROFESSOR);
//    }*/
//
//
//}
