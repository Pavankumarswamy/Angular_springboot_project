package com.cetnext.ecet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetnext.ecet.models.PricingPlan;
import java.util.List;

@Repository
public interface PricingPlanRepository extends JpaRepository<PricingPlan, Integer> {
    List<PricingPlan> findByIsActive(Boolean isActive);

    List<PricingPlan> findByIsPopular(Boolean isPopular);
}
