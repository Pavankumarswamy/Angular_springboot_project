package com.cetnext.ecet.repository;

import com.cetnext.ecet.models.ContentSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContentSectionRepository extends JpaRepository<ContentSection, Long> {
    List<ContentSection> findBySectionTypeAndIsActiveTrueOrderByDisplayOrderAsc(String sectionType);

    List<ContentSection> findByIsActiveTrueOrderByDisplayOrderAsc();
}
