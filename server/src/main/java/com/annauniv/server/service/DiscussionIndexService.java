package com.annauniv.server.service;

import com.annauniv.server.model.DiscussionIndex;
import com.annauniv.server.model.DiscussionText;
import com.annauniv.server.repository.DiscussionIndexJpaRepository;
import com.annauniv.server.repository.DiscussionTextJpaRepository;
import com.mongodb.client.DistinctIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiscussionIndexService {
    @Autowired
    MongoTemplate mongoTemplate;

    Timestamp instant= Timestamp.from(Instant.now());
    private final DiscussionIndexJpaRepository discussionIndexJpaRepository;

    private final DiscussionTextJpaRepository discussionTextJpaRepository;

    @Autowired
    public DiscussionIndexService(DiscussionIndexJpaRepository discussionIndexJpaRepository, DiscussionTextJpaRepository discussionTextJpaRepository) {
        this.discussionIndexJpaRepository = discussionIndexJpaRepository;
        this.discussionTextJpaRepository = discussionTextJpaRepository;
    }

    public List<DiscussionIndex> listAllDiscussion(){
        return discussionIndexJpaRepository.findAll();
    }

    public Long getCountofUsersUnique(){
        DistinctIterable<Integer> res = mongoTemplate.getCollection("discussionText").distinct("userID", Integer.class);
        Long counter = Long.valueOf(0);
        for (Object i : res) {
            counter++;
        }
        Long len =  counter;
        return len;
    }

    public List<Long> getListofAllUniqueParticipants(Long discussionID){
        DistinctIterable<DiscussionText> val = mongoTemplate.getCollection("discussionText").distinct("userID", DiscussionText.class);
        System.out.println(val);
        Set<Long> result = new HashSet<>();
        List<Long> res = new ArrayList<>();
        for(DiscussionText vals : val){
            result.add(vals.getUserID());
        }
        System.out.println(result);
        return res;
    }
}
