package com.annauniv.server.service;

import com.annauniv.server.authority.UserAccountDesignation;
import com.annauniv.server.model.DiscussionIndex;
import com.annauniv.server.model.DiscussionText;
import com.annauniv.server.repository.DiscussionIndexJpaRepository;
import com.annauniv.server.repository.DiscussionTextJpaRepository;
import com.mongodb.client.DistinctIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiscussionIndexService {

    @Autowired
    MongoOperations mongoOperations;
    @Autowired
    MongoTemplate mongoTemplate;

    Timestamp instant= Timestamp.from(Instant.now());
    private final DiscussionIndexJpaRepository discussionIndexJpaRepository;
    @Autowired
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

    public List<BigInteger> getListofAllUniqueParticipants(Long discussionID){
        DistinctIterable<DiscussionText> val = mongoTemplate.getCollection("DiscussionText").distinct("userID", DiscussionText.class);
        System.out.println(val);
        Set<BigInteger> result = new HashSet<>();
        List<BigInteger> res = new ArrayList<>();
        for(DiscussionText vals : val){
            result.add(vals.getUserID());
        }
        System.out.println(result);
        return res;
    }

    public void insertIntoDiscussionText(DiscussionText discussionText){
        mongoOperations.insert(discussionText);
    }

    public List<DiscussionText> getUserDiscussionText(Long disscussionID) {
        Criteria criteria = new Criteria();
        criteria = criteria.and("discussionID").is(disscussionID);
        Query qry = new Query(criteria);

        List<DiscussionText> res = mongoOperations.find(qry,DiscussionText.class);
        System.out.println(res);
        return res;
    }

    public List<DiscussionText> getAllDiscussionText(){

        List<DiscussionText> res = mongoOperations.findAll(DiscussionText.class);

        return res;
    }

    public void insertDiscussion(Long id,Long discussionId, String discussionName, String text, UserAccountDesignation accessClass){
        DiscussionIndex vals = new DiscussionIndex(id,discussionId,discussionName,text,instant,accessClass);
        discussionIndexJpaRepository.save(vals);
    }
}
