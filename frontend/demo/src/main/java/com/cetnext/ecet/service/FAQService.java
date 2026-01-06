package com.cetnext.ecet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.FAQ;
import com.cetnext.ecet.repository.FAQRepository;

@Service
public class FAQService {
    @Autowired
    private FAQRepository repository;

    public String addFAQ(FAQ faq) {
        repository.save(faq);
        return "FAQ added successfully";
    }

    public List<FAQ> getAllFAQs() {
        return repository.findAll();
    }

    public List<FAQ> getActiveFAQs() {
        return repository.findByIsActiveOrderByDisplayOrder(true);
    }

    public List<FAQ> getFAQsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Optional<FAQ> getFAQById(Integer id) {
        return repository.findById(id);
    }

    public String updateFAQ(Integer id, FAQ faq) {
        if (repository.existsById(id)) {
            faq.setId(id);
            repository.save(faq);
            return "FAQ updated successfully";
        }
        return "FAQ not found";
    }

    public String deleteFAQ(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "FAQ deleted successfully";
        }
        return "FAQ not found";
    }
}
