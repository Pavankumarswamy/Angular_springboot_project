package com.cetnext.ecet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.Contact;
import com.cetnext.ecet.repository.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public String submitContact(Contact contact) {
        repository.save(contact);
        return "Contact form submitted successfully";
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public List<Contact> getUnreadContacts() {
        return repository.findByIsRead(false);
    }

    public List<Contact> getUnrepliedContacts() {
        return repository.findByIsReplied(false);
    }

    public List<Contact> getContactsByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<Contact> getContactById(Integer id) {
        return repository.findById(id);
    }

    public String markAsRead(Integer id) {
        Optional<Contact> contact = repository.findById(id);
        if (contact.isPresent()) {
            Contact c = contact.get();
            c.setIsRead(true);
            repository.save(c);
            return "Contact marked as read";
        }
        return "Contact not found";
    }

    public String markAsReplied(Integer id) {
        Optional<Contact> contact = repository.findById(id);
        if (contact.isPresent()) {
            Contact c = contact.get();
            c.setIsReplied(true);
            repository.save(c);
            return "Contact marked as replied";
        }
        return "Contact not found";
    }

    public String deleteContact(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Contact deleted successfully";
        }
        return "Contact not found";
    }
}
