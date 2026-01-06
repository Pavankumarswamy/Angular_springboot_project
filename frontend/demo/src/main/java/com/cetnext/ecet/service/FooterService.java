package com.cetnext.ecet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.Footer;
import com.cetnext.ecet.repository.FooterRepository;

@Service
public class FooterService {
    @Autowired
    private FooterRepository repository;

    public String addFooterItem(Footer footer) {
        repository.save(footer);
        return "Footer item added successfully";
    }

    public List<Footer> getAllFooterItems() {
        return repository.findAll();
    }

    public List<Footer> getActiveFooterItems() {
        return repository.findByIsActiveOrderByDisplayOrder(true);
    }

    public List<Footer> getFooterItemsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Optional<Footer> getFooterItemById(Integer id) {
        return repository.findById(id);
    }

    public String updateFooterItem(Integer id, Footer footer) {
        if (repository.existsById(id)) {
            footer.setId(id);
            repository.save(footer);
            return "Footer item updated successfully";
        }
        return "Footer item not found";
    }

    public String deleteFooterItem(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Footer item deleted successfully";
        }
        return "Footer item not found";
    }
}
