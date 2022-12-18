package com.annauniv.server.repository;

import com.annauniv.server.model.DiscussionText;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
@Transactional
@Repository
public interface DiscussionTextMongoRepository extends MongoRepository<DiscussionText, BigInteger> {

    List<DiscussionText> findAllByDiscussionID(Long discussionID);

    List<DiscussionText> findAllByDiscussionIDAndAndUserID(Long discussionID, Long userID);

}
