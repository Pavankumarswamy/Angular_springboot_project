package com.cetnext.ecet.repository;

import com.cetnext.ecet.models.PageContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PageContentRepository extends JpaRepository<PageContent, Long> {
    List<PageContent> findByPageNameAndIsActiveTrueOrderByDisplayOrderAsc(String pageName);

    List<PageContent> findByPageNameAndSectionTypeAndIsActiveTrueOrderByDisplayOrderAsc(String pageName,
            String sectionType);
}
