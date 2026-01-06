package com.cetnext.ecet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetnext.ecet.models.Testimonial;
import java.util.List;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Integer> {
    List<Testimonial> findByIsApproved(Boolean isApproved);

    List<Testimonial> findByExamYear(String examYear);
}
