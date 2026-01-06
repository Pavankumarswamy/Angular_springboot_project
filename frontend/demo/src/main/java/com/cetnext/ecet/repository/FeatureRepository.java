package com.cetnext.ecet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetnext.ecet.models.Feature;
import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
    List<Feature> findByIsActiveOrderByDisplayOrder(Boolean isActive);
}
