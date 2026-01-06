package com.cetnext.ecet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetnext.ecet.models.Contact;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByIsRead(Boolean isRead);

    List<Contact> findByIsReplied(Boolean isReplied);

    List<Contact> findByEmail(String email);
}
