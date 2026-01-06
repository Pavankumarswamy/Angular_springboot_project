package com.cetnext.ecet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetnext.ecet.models.Newsletter;
import java.util.List;
import java.util.Optional;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Integer> {
    List<Newsletter> findByIsActive(Boolean isActive);

    Optional<Newsletter> findByEmail(String email);

    Boolean existsByEmail(String email);
}
