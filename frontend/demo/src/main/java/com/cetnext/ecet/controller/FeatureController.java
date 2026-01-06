package com.cetnext.ecet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetnext.ecet.models.Feature;
import com.cetnext.ecet.service.FeatureService;

@RestController
@RequestMapping("/api/v1/features")
@CrossOrigin(origins = "*")
public class FeatureController {

    @Autowired
    private FeatureService service;

    @PostMapping("/add")
    public ResponseEntity<String> addFeature(@RequestBody Feature feature) {
        String result = service.addFeature(feature);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Feature>> getAllFeatures() {
        return ResponseEntity.ok(service.getAllFeatures());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Feature>> getActiveFeatures() {
        return ResponseEntity.ok(service.getActiveFeatures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Feature>> getFeatureById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFeatureById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFeature(@PathVariable Integer id, @RequestBody Feature feature) {
        String result = service.updateFeature(id, feature);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeature(@PathVariable Integer id) {
        String result = service.deleteFeature(id);
        return ResponseEntity.ok(result);
    }
}
