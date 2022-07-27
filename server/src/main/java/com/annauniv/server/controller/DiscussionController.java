package com.annauniv.server.controller;

import com.annauniv.server.model.DiscussionIndex;
import com.annauniv.server.service.DiscussionIndexService;
import com.annauniv.server.service.DiscussionTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/discussions")
public class DiscussionController {
    private final DiscussionIndexService discussionIndexService;
    private final DiscussionTextService discussionTextService;


    @Autowired
    public DiscussionController(DiscussionIndexService discussionIndexService, DiscussionTextService discussionTextService) {
        this.discussionIndexService = discussionIndexService;
        this.discussionTextService = discussionTextService;
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


}
