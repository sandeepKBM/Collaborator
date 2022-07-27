package com.annauniv.server.repository;

import com.annauniv.server.model.DiscussionText;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionTextJpaRepository extends MongoRepository<DiscussionText,String> {

}
