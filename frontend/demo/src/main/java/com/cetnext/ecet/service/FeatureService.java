package com.cetnext.ecet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.Feature;
import com.cetnext.ecet.repository.FeatureRepository;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepository repository;

    public String addFeature(Feature feature) {
        repository.save(feature);
        return "Feature added successfully";
    }

    public List<Feature> getAllFeatures() {
        return repository.findAll();
    }

    public List<Feature> getActiveFeatures() {
        return repository.findByIsActiveOrderByDisplayOrder(true);
    }

    public Optional<Feature> getFeatureById(Integer id) {
        return repository.findById(id);
    }

    public String updateFeature(Integer id, Feature feature) {
        if (repository.existsById(id)) {
            feature.setId(id);
            repository.save(feature);
            return "Feature updated successfully";
        }
        return "Feature not found";
    }

    public String deleteFeature(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Feature deleted successfully";
        }
        return "Feature not found";
    }
}
