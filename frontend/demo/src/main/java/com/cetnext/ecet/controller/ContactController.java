package com.cetnext.ecet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetnext.ecet.models.Contact;
import com.cetnext.ecet.service.ContactService;

@RestController
@RequestMapping("/api/v1/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/submit")
    public ResponseEntity<String> submitContact(@RequestBody Contact contact) {
        String result = service.submitContact(contact);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/unread")
    public ResponseEntity<List<Contact>> getUnreadContacts() {
        return ResponseEntity.ok(service.getUnreadContacts());
    }

    @GetMapping("/unreplied")
    public ResponseEntity<List<Contact>> getUnrepliedContacts() {
        return ResponseEntity.ok(service.getUnrepliedContacts());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Contact>> getContactsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getContactsByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contact>> getContactById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getContactById(id));
    }

    @PatchMapping("/mark-read/{id}")
    public ResponseEntity<String> markAsRead(@PathVariable Integer id) {
        String result = service.markAsRead(id);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/mark-replied/{id}")
    public ResponseEntity<String> markAsReplied(@PathVariable Integer id) {
        String result = service.markAsReplied(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer id) {
        String result = service.deleteContact(id);
        return ResponseEntity.ok(result);
    }
}
