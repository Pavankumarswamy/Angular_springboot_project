package com.cetnext.ecet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.PricingPlan;
import com.cetnext.ecet.repository.PricingPlanRepository;

@Service
public class PricingPlanService {
    @Autowired
    private PricingPlanRepository repository;

    public String addPricingPlan(PricingPlan plan) {
        repository.save(plan);
        return "Pricing plan added successfully";
    }

    public List<PricingPlan> getAllPricingPlans() {
        return repository.findAll();
    }

    public List<PricingPlan> getActivePricingPlans() {
        return repository.findByIsActive(true);
    }

    public List<PricingPlan> getPopularPlans() {
        return repository.findByIsPopular(true);
    }

    public Optional<PricingPlan> getPricingPlanById(Integer id) {
        return repository.findById(id);
    }

    public String updatePricingPlan(Integer id, PricingPlan plan) {
        if (repository.existsById(id)) {
            plan.setId(id);
            repository.save(plan);
            return "Pricing plan updated successfully";
        }
        return "Pricing plan not found";
    }

    public String deletePricingPlan(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Pricing plan deleted successfully";
        }
        return "Pricing plan not found";
    }
}
