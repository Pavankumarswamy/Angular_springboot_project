package com.cetnext.ecet.repository;

import com.cetnext.ecet.models.MediaLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MediaLogoRepository extends JpaRepository<MediaLogo, Long> {
    List<MediaLogo> findByIsActiveTrueOrderByDisplayOrderAsc();
}
