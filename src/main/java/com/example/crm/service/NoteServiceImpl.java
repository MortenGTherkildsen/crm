package com.example.crm.service;

import com.example.crm.model.Note;
import com.example.crm.repository.INoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements com.example.crm.service.INoteService {

    @Autowired
    private INoteRepo noteRepo;

    @Override
    public Note createNote(Note n) {
        n.setId(0);
        n.setStatus(1);
        Date timestamp = new Date();
        n.setTimestamp(timestamp.toString());
        return noteRepo.save(n);
    }

    @Override
    public Note readNote(int NoteListIndex) {
        return noteRepo.getOne(NoteListIndex);
    }

    @Override
    public Note updateNote(Note note) { return noteRepo.save(note); }

    @Override
    public void deleteNote(int id) {
        noteRepo.deleteById(id);
    }

    @Override
    public List<Note> fetchAllNotes() {
        return noteRepo.findAll();
    }


}
