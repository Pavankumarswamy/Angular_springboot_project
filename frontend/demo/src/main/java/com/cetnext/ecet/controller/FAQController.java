package com.cetnext.ecet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetnext.ecet.models.FAQ;
import com.cetnext.ecet.service.FAQService;

@RestController
@RequestMapping("/api/v1/faq")
@CrossOrigin(origins = "*")
public class FAQController {

    @Autowired
    private FAQService service;

    @PostMapping("/add")
    public ResponseEntity<String> addFAQ(@RequestBody FAQ faq) {
        String result = service.addFAQ(faq);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FAQ>> getAllFAQs() {
        return ResponseEntity.ok(service.getAllFAQs());
    }

    @GetMapping("/active")
    public ResponseEntity<List<FAQ>> getActiveFAQs() {
        return ResponseEntity.ok(service.getActiveFAQs());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<FAQ>> getFAQsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.getFAQsByCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FAQ>> getFAQById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFAQById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFAQ(@PathVariable Integer id, @RequestBody FAQ faq) {
        String result = service.updateFAQ(id, faq);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFAQ(@PathVariable Integer id) {
        String result = service.deleteFAQ(id);
        return ResponseEntity.ok(result);
    }
}
