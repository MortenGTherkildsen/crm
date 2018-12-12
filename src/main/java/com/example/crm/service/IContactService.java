package com.example.crm.service;


import com.example.crm.model.Contact;

import java.util.List;

public interface IContactService {

    Contact createContact(Contact c);

    Contact fetchOneContact(int id);

    Contact updateContact(Contact c);

    void deleteContact(int id);

    List<Contact> fetchAllContacts();

}
