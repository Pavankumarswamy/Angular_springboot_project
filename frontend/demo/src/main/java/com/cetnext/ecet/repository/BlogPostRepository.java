package com.cetnext.ecet.repository;

import com.cetnext.ecet.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByIsActiveTrueOrderByPublishedDateDesc();

    List<BlogPost> findByIsActiveTrueOrderByDisplayOrderAsc();
}
