package com.cetnext.ecet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetnext.ecet.models.FAQ;
import java.util.List;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Integer> {
    List<FAQ> findByIsActiveOrderByDisplayOrder(Boolean isActive);

    List<FAQ> findByCategory(String category);
}
