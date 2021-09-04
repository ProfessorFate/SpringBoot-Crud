package com.example.springbootex.service;

import com.example.springbootex.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> list();

    void save(Contact contact);

    void delete(int id);

    Contact get(int id);
}
