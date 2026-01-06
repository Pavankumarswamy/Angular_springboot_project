package com.cetnext.ecet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetnext.ecet.models.Testimonial;
import com.cetnext.ecet.service.TestimonialService;

@RestController
@RequestMapping("/api/v1/testimonials")
@CrossOrigin(origins = "*")
public class TestimonialController {

    @Autowired
    private TestimonialService service;

    @PostMapping("/add")
    public ResponseEntity<String> addTestimonial(@RequestBody Testimonial testimonial) {
        String result = service.addTestimonial(testimonial);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Testimonial>> getAllTestimonials() {
        return ResponseEntity.ok(service.getAllTestimonials());
    }

    @GetMapping("/approved")
    public ResponseEntity<List<Testimonial>> getApprovedTestimonials() {
        return ResponseEntity.ok(service.getApprovedTestimonials());
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Testimonial>> getTestimonialsByYear(@PathVariable String year) {
        return ResponseEntity.ok(service.getTestimonialsByYear(year));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Testimonial>> getTestimonialById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTestimonialById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTestimonial(@PathVariable Integer id, @RequestBody Testimonial testimonial) {
        String result = service.updateTestimonial(id, testimonial);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/approve/{id}")
    public ResponseEntity<String> approveTestimonial(@PathVariable Integer id) {
        String result = service.approveTestimonial(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTestimonial(@PathVariable Integer id) {
        String result = service.deleteTestimonial(id);
        return ResponseEntity.ok(result);
    }
}
