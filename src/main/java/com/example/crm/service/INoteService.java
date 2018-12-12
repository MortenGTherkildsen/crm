package com.example.crm.service;


import com.example.crm.model.Note;

import java.sql.SQLException;
import java.util.List;

public interface INoteService {

    Note createNote(Note n);

    Note readNote(int id);

    Note updateNote(Note note);

    void deleteNote(int id);

    List<Note> fetchAllNotes();

}
