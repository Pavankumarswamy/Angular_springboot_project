package com.cetnext.ecet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetnext.ecet.models.Footer;
import java.util.List;

@Repository
public interface FooterRepository extends JpaRepository<Footer, Integer> {
    List<Footer> findByIsActiveOrderByDisplayOrder(Boolean isActive);

    List<Footer> findByCategory(String category);
}
