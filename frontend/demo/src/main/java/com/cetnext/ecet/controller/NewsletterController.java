package com.cetnext.ecet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetnext.ecet.models.Newsletter;
import com.cetnext.ecet.service.NewsletterService;

@RestController
@RequestMapping("/api/v1/newsletter")
@CrossOrigin(origins = "*")
public class NewsletterController {

    @Autowired
    private NewsletterService service;

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestBody Newsletter newsletter) {
        String result = service.subscribe(newsletter);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Newsletter>> getAllSubscriptions() {
        return ResponseEntity.ok(service.getAllSubscriptions());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Newsletter>> getActiveSubscriptions() {
        return ResponseEntity.ok(service.getActiveSubscriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Newsletter>> getSubscriptionById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getSubscriptionById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Newsletter>> getSubscriptionByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getSubscriptionByEmail(email));
    }

    @PatchMapping("/unsubscribe/{email}")
    public ResponseEntity<String> unsubscribe(@PathVariable String email) {
        String result = service.unsubscribe(email);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubscription(@PathVariable Integer id) {
        String result = service.deleteSubscription(id);
        return ResponseEntity.ok(result);
    }
}
