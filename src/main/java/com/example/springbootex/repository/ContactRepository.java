package com.example.springbootex.repository;

import com.example.springbootex.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
