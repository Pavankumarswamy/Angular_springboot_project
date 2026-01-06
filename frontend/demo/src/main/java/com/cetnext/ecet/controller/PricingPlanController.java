package com.cetnext.ecet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetnext.ecet.models.PricingPlan;
import com.cetnext.ecet.service.PricingPlanService;

@RestController
@RequestMapping("/api/v1/pricing")
@CrossOrigin(origins = "*")
public class PricingPlanController {

    @Autowired
    private PricingPlanService service;

    @PostMapping("/add")
    public ResponseEntity<String> addPricingPlan(@RequestBody PricingPlan plan) {
        String result = service.addPricingPlan(plan);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PricingPlan>> getAllPricingPlans() {
        return ResponseEntity.ok(service.getAllPricingPlans());
    }

    @GetMapping("/active")
    public ResponseEntity<List<PricingPlan>> getActivePricingPlans() {
        return ResponseEntity.ok(service.getActivePricingPlans());
    }

    @GetMapping("/popular")
    public ResponseEntity<List<PricingPlan>> getPopularPlans() {
        return ResponseEntity.ok(service.getPopularPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PricingPlan>> getPricingPlanById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPricingPlanById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePricingPlan(@PathVariable Integer id, @RequestBody PricingPlan plan) {
        String result = service.updatePricingPlan(id, plan);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePricingPlan(@PathVariable Integer id) {
        String result = service.deletePricingPlan(id);
        return ResponseEntity.ok(result);
    }
}
