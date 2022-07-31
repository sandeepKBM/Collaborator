package com.annauniv.server.controller;

import com.annauniv.server.authority.UserAccountDesignation;
import com.annauniv.server.model.DiscussionIndex;
import com.annauniv.server.repository.DiscussionIndexJpaRepository;
import com.annauniv.server.repository.DiscussionTextJpaRepository;
import com.annauniv.server.service.DiscussionIndexService;
import com.annauniv.server.service.DiscussionTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/discussions")
public class DiscussionController {
    Date date = new Date();

    // getting the object of the Timestamp class
    Timestamp instant = new Timestamp(date.getTime());
    private final DiscussionIndexService discussionIndexService;
    private final DiscussionTextService discussionTextService;

    private final DiscussionTextJpaRepository discussionTextJpaRepository;

    private final DiscussionIndexJpaRepository discussionIndexJpaRepository;


    @Autowired
    public DiscussionController(DiscussionIndexService discussionIndexService, DiscussionTextService discussionTextService, DiscussionTextJpaRepository discussionTextJpaRepository, DiscussionIndexJpaRepository discussionIndexJpaRepository) {
        this.discussionIndexService = discussionIndexService;
        this.discussionTextService = discussionTextService;
        this.discussionTextJpaRepository = discussionTextJpaRepository;
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

    @GetMapping("/hope")
    public String test(){
        discussionIndexService.getListofAllUniqueParticipants(2L);
        DiscussionIndex x = new DiscussionIndex(1L,2L,"chaos","chaos",instant, UserAccountDesignation.DEAN);
        discussionIndexJpaRepository.save(x);

        return "works";

    }


}
