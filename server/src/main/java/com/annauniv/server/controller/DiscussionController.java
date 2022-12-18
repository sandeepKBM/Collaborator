package com.annauniv.server.controller;

import com.annauniv.server.authority.UserAccountDesignation;
import com.annauniv.server.model.DiscussionIndex;
import com.annauniv.server.model.DiscussionText;
import com.annauniv.server.repository.DiscussionIndexJpaRepository;
import com.annauniv.server.repository.DiscussionTextMongoRepository;
import com.annauniv.server.service.DiscussionIndexService;
import com.annauniv.server.service.DiscussionTextService;
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
@RequestMapping("api/discussions")
public class DiscussionController {

    @Autowired
    MongoOperations mongoOperations;
    Date date = new Date();

    // getting the object of the Timestamp class
    Timestamp instant = new Timestamp(date.getTime());
    @Autowired
    private final DiscussionIndexService discussionIndexService;
    private final DiscussionTextService discussionTextService;

    private final DiscussionTextMongoRepository discussionTextMongoRepository;

    private final DiscussionIndexJpaRepository discussionIndexJpaRepository;


    @Autowired
    public DiscussionController(DiscussionIndexService discussionIndexService, DiscussionTextService discussionTextService, DiscussionTextMongoRepository discussionTextMongoRepository, DiscussionIndexJpaRepository discussionIndexJpaRepository) {
        this.discussionIndexService = discussionIndexService;
        this.discussionTextService = discussionTextService;
        this.discussionTextMongoRepository = discussionTextMongoRepository;
        this.discussionIndexJpaRepository = discussionIndexJpaRepository;
    }

    @GetMapping("/listAll")
    public @ResponseBody List<DiscussionIndex> discussionList(){

        return discussionIndexService.listAllDiscussion();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> printCount(){
        Long siz = discussionIndexService.getCountofUsersUnique();
        System.out.println(siz);
        return ResponseEntity.ok(siz);
    }

    @PostMapping("/insertchat")
    public void insertDiscussionChat(@RequestParam Long parentId, @RequestParam String Text,@RequestParam Long dissID,@RequestParam BigInteger userID){
        DiscussionText obj = new DiscussionText(parentId, Text,dissID,userID,instant);
        discussionIndexService.insertIntoDiscussionText(obj);
    }

//    @GetMapping("/tester")
//    public void tester(@Re){
//
//    }
    @GetMapping("/alltext")
    public List<DiscussionText> getAllDiscussionText(){
        return discussionIndexService.getAllDiscussionText();
    }

    @GetMapping("/alldisstext")
    public List<DiscussionText> getAllDiscussionText(@RequestParam Long disscussionID){

            return discussionIndexService.getUserDiscussionText(disscussionID);
    }

    @PostMapping("/insertDiscusssion")
    public void insertDiscussion(@RequestParam Long userid ,@RequestParam Long discussionId, @RequestParam String discussionName,@RequestParam String description){
        discussionIndexService.insertDiscussion(discussionId,userid,discussionName,description,UserAccountDesignation.PROFESSOR);
    }


}
