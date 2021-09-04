package com.example.springbootex.service;

import com.example.springbootex.model.Contact;
import com.example.springbootex.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public List<Contact> list() {
        return contactRepository.findAll();
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact get(int id) {
        return contactRepository.findById(id).get();
    }
}