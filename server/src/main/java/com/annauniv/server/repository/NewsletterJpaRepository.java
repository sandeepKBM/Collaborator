package com.annauniv.server.repository;

import com.annauniv.server.model.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NewsletterJpaRepository extends JpaRepository<Newsletter,Long> {
    List<Newsletter> findAllByid(Long id);
}
