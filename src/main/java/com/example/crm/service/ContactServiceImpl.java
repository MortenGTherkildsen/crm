package com.example.crm.service;

import com.example.crm.model.Contact;
import com.example.crm.repository.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private IContactRepo contactRepo;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public Contact fetchOneContact(int id) {
        return contactRepo.getOne(id);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public void deleteContact(int id) {
        contactRepo.deleteById(id);
    }

    @Override
    public List<Contact> fetchAllContacts() {
        return contactRepo.findAll();
    }

    @Override
    public List<String> contactFields() {
        List<String> contactFields = new ArrayList<>();
        contactFields.add("FirstName");
        contactFields.add("LastName");
        contactFields.add("NickName");
        contactFields.add("Email");
        contactFields.add("Phone");
        contactFields.add("CVR");
        contactFields.add("DOB");
        contactFields.add("Adress1");
        contactFields.add("Adress2");
        contactFields.add("City");
        contactFields.add("PostalCode");
        contactFields.add("Country");
        contactFields.add("Website");
        contactFields.add("Facebook");
        contactFields.add("Trello");
        contactFields.add("GitHub");
        contactFields.add("Gmail");
        return contactFields;
    }

}
