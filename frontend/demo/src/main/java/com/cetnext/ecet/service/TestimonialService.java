package com.cetnext.ecet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.Testimonial;
import com.cetnext.ecet.repository.TestimonialRepository;

@Service
public class TestimonialService {
    @Autowired
    private TestimonialRepository repository;

    public String addTestimonial(Testimonial testimonial) {
        repository.save(testimonial);
        return "Testimonial added successfully";
    }

    public List<Testimonial> getAllTestimonials() {
        return repository.findAll();
    }

    public List<Testimonial> getApprovedTestimonials() {
        return repository.findByIsApproved(true);
    }

    public List<Testimonial> getTestimonialsByYear(String year) {
        return repository.findByExamYear(year);
    }

    public Optional<Testimonial> getTestimonialById(Integer id) {
        return repository.findById(id);
    }

    public String updateTestimonial(Integer id, Testimonial testimonial) {
        if (repository.existsById(id)) {
            testimonial.setId(id);
            repository.save(testimonial);
            return "Testimonial updated successfully";
        }
        return "Testimonial not found";
    }

    public String approveTestimonial(Integer id) {
        Optional<Testimonial> testimonial = repository.findById(id);
        if (testimonial.isPresent()) {
            Testimonial t = testimonial.get();
            t.setIsApproved(true);
            repository.save(t);
            return "Testimonial approved successfully";
        }
        return "Testimonial not found";
    }

    public String deleteTestimonial(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Testimonial deleted successfully";
        }
        return "Testimonial not found";
    }
}
