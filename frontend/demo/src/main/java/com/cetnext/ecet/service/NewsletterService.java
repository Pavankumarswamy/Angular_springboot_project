package com.cetnext.ecet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.Newsletter;
import com.cetnext.ecet.repository.NewsletterRepository;

@Service
public class NewsletterService {
    @Autowired
    private NewsletterRepository repository;

    public String subscribe(Newsletter newsletter) {
        if (repository.existsByEmail(newsletter.getEmail())) {
            return "Email already subscribed";
        }
        repository.save(newsletter);
        return "Successfully subscribed to newsletter";
    }

    public List<Newsletter> getAllSubscriptions() {
        return repository.findAll();
    }

    public List<Newsletter> getActiveSubscriptions() {
        return repository.findByIsActive(true);
    }

    public Optional<Newsletter> getSubscriptionById(Integer id) {
        return repository.findById(id);
    }

    public Optional<Newsletter> getSubscriptionByEmail(String email) {
        return repository.findByEmail(email);
    }

    public String unsubscribe(String email) {
        Optional<Newsletter> subscription = repository.findByEmail(email);
        if (subscription.isPresent()) {
            Newsletter n = subscription.get();
            n.setIsActive(false);
            repository.save(n);
            return "Successfully unsubscribed";
        }
        return "Email not found";
    }

    public String deleteSubscription(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Subscription deleted successfully";
        }
        return "Subscription not found";
    }
}
