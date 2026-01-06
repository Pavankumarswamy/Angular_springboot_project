package com.cetnext.ecet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetnext.ecet.models.Footer;
import com.cetnext.ecet.service.FooterService;

@RestController
@RequestMapping("/api/v1/footer")
@CrossOrigin(origins = "*")
public class FooterController {

    @Autowired
    private FooterService service;

    @PostMapping("/add")
    public ResponseEntity<String> addFooterItem(@RequestBody Footer footer) {
        String result = service.addFooterItem(footer);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Footer>> getAllFooterItems() {
        return ResponseEntity.ok(service.getAllFooterItems());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Footer>> getActiveFooterItems() {
        return ResponseEntity.ok(service.getActiveFooterItems());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Footer>> getFooterItemsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.getFooterItemsByCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Footer>> getFooterItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFooterItemById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFooterItem(@PathVariable Integer id, @RequestBody Footer footer) {
        String result = service.updateFooterItem(id, footer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFooterItem(@PathVariable Integer id) {
        String result = service.deleteFooterItem(id);
        return ResponseEntity.ok(result);
    }
}
