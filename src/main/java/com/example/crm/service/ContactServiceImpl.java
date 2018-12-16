package com.example.crm.service;

import com.example.crm.model.Contact;
import com.example.crm.model.Note;
import com.example.crm.model.Utilities;
import com.example.crm.repository.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private IContactRepo contactRepo;

    @Autowired
    INoteService noteService;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public Contact fetchOneContact(int id) { return contactRepo.getOne(id); }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public void deleteContact(int id) {
        Contact c = this.fetchOneContact(id);
        List<Note> notes = c.getNotes();
        for (Note n: notes) {
            noteService.deleteNote(n.getId());
        }
        contactRepo.deleteById(id);
    }

    @Override
    public List<Contact> fetchAllContacts() {
        return contactRepo.findAll();
    }

}
