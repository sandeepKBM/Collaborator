package com.annauniv.server.repository;

import com.annauniv.server.model.DiscussionIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DiscussionIndexJpaRepository extends JpaRepository<DiscussionIndex,Long> {
}
