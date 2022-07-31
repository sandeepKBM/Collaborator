package com.annauniv.server.repository;

import com.annauniv.server.model.DiscussionIndex;
import com.annauniv.server.model.DiscussionText;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DiscussionTextJpaRepository extends MongoRepository<DiscussionText,String> {

    List<DiscussionText> findAllByDiscussionID(Long discussionID);
}
