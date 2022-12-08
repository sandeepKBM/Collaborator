package com.annauniv.server.repository;

import com.annauniv.server.model.Newsletter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
@Transactional
@Repository
public interface NewsletterJpaRepository extends MongoRepository<Newsletter, BigInteger> {

    /*List<DiscussionText> findAllByDiscussionID(Long discussionID);

    List<DiscussionText> findAllByDiscussionIDAndAndUserID(Long discussionID, Long userID);*/

}
